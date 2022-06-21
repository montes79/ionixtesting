package montes.luis.mireddit.permisos

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import montes.luis.mireddit.R

class PermisosAplicacion(private val contexto:Context,private val actividad: Activity) {

     fun verificarPermisoEscritura(): Boolean {
        val resultado = ContextCompat.checkSelfPermission(
            contexto,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return resultado == PackageManager.PERMISSION_GRANTED
    }



     fun solicitarPermisoEscritura(PERMISO_CLAVE:Int) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                actividad,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            Toast.makeText(
                contexto,
                contexto.getString(R.string.sin_permiso_escritura),
                Toast.LENGTH_LONG
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                actividad,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISO_CLAVE
            )
        }
    }



}