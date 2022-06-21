package montes.luis.mireddit.modulos

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import montes.luis.mireddit.servicios.servicioReddit
import montes.luis.mireddit.utilidades.Constantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module //Modulos proveen dependencias que no se pueden inyectar con @Inject
@InstallIn(SingletonComponent::class) //Alcance a nivel de activity..

object ModuloRed {

    @Singleton  //Sin singleton se va crear una instancia nueva..Patron de diseño: Unica instancia
    @Provides
    fun proveeRetrofit(): Retrofit {
        val urlBase:String= Constantes.urlBase
        return Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun proveeAPI(retrofit: Retrofit): servicioReddit {
        return retrofit.create(servicioReddit::class.java)
    }




}