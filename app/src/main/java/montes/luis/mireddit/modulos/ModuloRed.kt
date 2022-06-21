package montes.luis.mireddit.modulos

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import montes.luis.mireddit.servicios.ApiReddit
import montes.luis.mireddit.utilidades.Constantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.security.cert.CertificateException
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


@Module //Modulos proveen dependencias que no se pueden inyectar con @Inject
@InstallIn(SingletonComponent::class) //Alcance a nivel de activity..
//object
class ModuloRed {

    private val sslContext: SSLContext = SSLContext.getInstance("SSL")

    private val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        @Throws(CertificateException::class)
        override fun checkClientTrusted(
            chain: Array<java.security.cert.X509Certificate>,
            authType: String
        ) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(
            chain: Array<java.security.cert.X509Certificate>,
            authType: String
        ) {
        }

        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
            return arrayOf()
        }
    })

    @Singleton  //Sin singleton se va crear una instancia nueva..Patron de diseño: Unica instancia
    @Provides
    fun provideRetrofit(): Retrofit {
        val urlBase: String = Constantes.urlBase

        return Retrofit.Builder()
            .client(clientOkHttp())
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }


    @Singleton
    @Provides
    fun provideApiReddit(retrofit: Retrofit): ApiReddit {
        return retrofit.create(ApiReddit::class.java)
    }


    private fun clientOkHttp(retry: Boolean = true): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        builder.connectTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .protocols(Collections.singletonList(Protocol.HTTP_1_1))
            .retryOnConnectionFailure(retry)
        builder.hostnameVerifier { _, _ -> true }
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        return builder.build()
    }



}