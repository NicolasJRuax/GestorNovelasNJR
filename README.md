# Gestor de Novelas

Gestor de Novelas es una aplicación Android desarrollada en Java que permite a los usuarios gestionar una colección de novelas. La aplicación ofrece funcionalidades como agregar, eliminar, marcar como favoritas y sincronizar datos con Firebase Firestore. Además, utiliza notificaciones para informar al usuario sobre el estado de la sincronización.

## Características

- **Agregar Novelas**: Permite a los usuarios añadir nuevas novelas con detalles como título, autor, año de publicación y sinopsis.
- **Eliminar Novelas**: Los usuarios pueden eliminar novelas de su colección.
- **Favoritos**: Marcar o desmarcar novelas como favoritas para un acceso rápido.
- **Sincronización de Datos**: Sincroniza los datos de las novelas con Firebase Firestore, ya sea manualmente o automáticamente cada 12 horas.
- **Notificaciones**: Notifica al usuario cuando la sincronización de datos se completa.
- **Detección de Conexión Wi-Fi**: Detecta cambios en la conectividad de red y sincroniza datos automáticamente cuando está conectado a una red Wi-Fi.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **IDE**: Android Studio
- **Base de Datos**: Firebase Firestore
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **Librerías**:
  - AndroidX (AppCompat, RecyclerView, Lifecycle, etc.)
  - Google Firebase
  - Material Design

## Instalación

### Prerrequisitos

- Android Studio 4.0 o superior.
- Cuenta de Firebase con un proyecto configurado.
- Dispositivo Android o emulador para ejecutar la aplicación.

### Pasos

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/tu-usuario/gestor-novelas.git


   com.myproyect.gestornovelasnjr.gestor_novelas
├── MainActivity: Actividad principal que maneja la interfaz de usuario y las interacciones.
├── Novelas:
│   ├── Novel: Clase de modelo que representa una novela.
│   ├── NovelAdapter: Adaptador para el RecyclerView que muestra la lista de novelas.
│   ├── NovelViewModel: ViewModel para gestionar datos de novelas.
│   ├── NovelRepository: Repositorio que interactúa con Firebase Firestore.
│   └── NovelLoader: Carga asincrónica de novelas.
├── Sync:
│   ├── SyncDataTask: Tarea asincrónica para sincronizar datos con Firestore.
│   ├── SyncAlarmReceiver: Receiver para alarmas de sincronización periódica.
│   ├── SyncDataReceiver: Receiver para manejar el broadcast de sincronización completada.
│   ├── ConnectivityReceiver: Receiver para detectar cambios en la conectividad de red.
│   ├── NetworkUtil: Utilidades para verificar el estado de la red.
│   └── NotificationHelper: Helper para mostrar notificaciones.
└── DB:
    ├── NovelDAO: Data Access Object para operaciones de base de datos.
    └── AddNovelActivity: Actividad para agregar novelas a la base de datos.

