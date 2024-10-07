package com.myproyect.gestornovelasnjr.gestor_novelas.Sync;

import static org.junit.jupiter.api.Assertions.*;



import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NetworkUtilTest {

    private Context mockContext;
    private ConnectivityManager mockConnectivityManager;
    private NetworkInfo mockNetworkInfo;

    @Before
    public void setUp() {
        // Crear mocks
        mockContext = mock(Context.class);
        mockConnectivityManager = mock(ConnectivityManager.class);
        mockNetworkInfo = mock(NetworkInfo.class);

        // Configurar el comportamiento del contexto para devolver el ConnectivityManager mockeado
        when(mockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager);
    }

    @Test
    public void testIsConnectedToWifi_Connected() {
        // Configurar el NetworkInfo para simular una conexión Wi-Fi activa
        when(mockConnectivityManager.getActiveNetworkInfo()).thenReturn(mockNetworkInfo);
        when(mockNetworkInfo.isConnected()).thenReturn(true);
        when(mockNetworkInfo.getType()).thenReturn(ConnectivityManager.TYPE_WIFI);

        // Ejecutar el método a probar
        boolean result = NetworkUtil.isConnectedToWifi(mockContext);

        // Verificar el resultado
        assertTrue(result);
    }

    @Test
    public void testIsConnectedToWifi_NotConnected() {
        // Configurar el NetworkInfo para simular que no está conectado
        when(mockConnectivityManager.getActiveNetworkInfo()).thenReturn(null);

        // Ejecutar el método a probar
        boolean result = NetworkUtil.isConnectedToWifi(mockContext);

        // Verificar el resultado
        assertFalse(result);
    }

    @Test
    public void testIsConnectedToWifi_ConnectedButNotWifi() {
        // Configurar el NetworkInfo para simular una conexión activa pero no Wi-Fi
        when(mockConnectivityManager.getActiveNetworkInfo()).thenReturn(mockNetworkInfo);
        when(mockNetworkInfo.isConnected()).thenReturn(true);
        when(mockNetworkInfo.getType()).thenReturn(ConnectivityManager.TYPE_MOBILE);

        // Ejecutar el método a probar
        boolean result = NetworkUtil.isConnectedToWifi(mockContext);

        // Verificar el resultado
        assertFalse(result);
    }
}
