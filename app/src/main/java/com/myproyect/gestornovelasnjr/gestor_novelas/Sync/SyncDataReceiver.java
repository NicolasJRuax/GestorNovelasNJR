package com.myproyect.gestornovelasnjr.gestor_novelas.Sync;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SyncDataReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Comprobar si el evento es el esperado (evento de sincronización completada)
        if (intent.getAction() != null && intent.getAction().equals("com.myproyect.gestornovelasnjr.SYNC_COMPLETE")) {
            // Mostrar un mensaje o realizar alguna acción
            Toast.makeText(context, "Sincronización completada con éxito", Toast.LENGTH_SHORT).show();
        }
    }
}

