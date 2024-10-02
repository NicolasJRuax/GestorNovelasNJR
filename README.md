Gestor de Novelas
Descripción
El Gestor de Novelas es una aplicación Android diseñada para gestionar una biblioteca personal de novelas. Permite agregar, eliminar, ver detalles y marcar novelas como favoritas. Además, sincroniza los datos con un servidor remoto (Firebase Firestore) en segundo plano, notificando al usuario sobre eventos importantes.

Características
Agregar Novelas: Los usuarios pueden agregar nuevas novelas proporcionando título, autor, año de publicación y sinopsis.
Eliminar Novelas: Permite eliminar novelas de la biblioteca personal.
Ver Detalles: Los usuarios pueden ver detalles completos de cada novela.
Marcar como Favorito: Posibilidad de marcar o desmarcar novelas como favoritas.
Sincronización en Segundo Plano: Los datos se sincronizan con el servidor en segundo plano utilizando AsyncTask.
Notificaciones: Notifica al usuario cuando la sincronización se completa u ocurre algún evento importante.
Sincronización Automática: La aplicación detecta cuando el dispositivo se conecta a Wi-Fi y sincroniza automáticamente.
Sincronización Periódica: Utiliza AlarmManager para sincronizar datos en intervalos programados.
Carga Asíncrona de Datos: Utiliza AsyncTaskLoader para cargar datos de manera eficiente.
Instalación y Configuración
Clonar el Repositorio: Clona el repositorio en tu máquina local.
Configurar Firebase: Asegúrate de tener una instancia de Firebase Firestore configurada y actualiza los archivos de configuración de Firebase en tu proyecto.
Permisos: Verifica que los permisos necesarios estén declarados en el AndroidManifest.xml.
Dependencias: Asegúrate de que todas las dependencias en el archivo build.gradle estén actualizadas.
Ejecutar la Aplicación: Compila y ejecuta la aplicación en un dispositivo o emulador Android.

Cómo Funciona la Aplicación
Flujo General
Inicialización: Al iniciar, MainActivity configura la interfaz de usuario y el RecyclerView para mostrar la lista de novelas. Utiliza NovelViewModel para obtener los datos.
Agregar Novelas: Al presionar el botón "Agregar Novela", se muestra un diálogo donde el usuario puede ingresar los detalles de la novela. Al confirmar, la novela se inserta en Firebase Firestore a través de NovelViewModel y NovelRepository.
Eliminar Novelas: Los usuarios pueden eliminar novelas desde la lista. Al presionar el botón de eliminar, se elimina la novela de Firestore y la interfaz se actualiza.
Ver Detalles y Marcar como Favorito: Los usuarios pueden ver detalles de una novela y marcarla o desmarcarla como favorita desde la lista.
Sincronización Manual: El botón "Sincronizar Datos" permite al usuario iniciar una sincronización manual. Se ejecuta SyncDataTask para sincronizar con el servidor.
Sincronización Automática: La aplicación detecta cuando el dispositivo se conecta a Wi-Fi utilizando ConnectivityReceiver y sincroniza automáticamente.
Sincronización Periódica: AlarmManager programa sincronizaciones periódicas cada 12 horas mediante SyncAlarmReceiver.
Notificaciones: Al completar la sincronización, SyncDataReceiver muestra una notificación al usuario utilizando NotificationHelper.

Explicación de las Relaciones
MainActivity: Es la actividad principal que gestiona la interfaz de usuario y las interacciones del usuario. Utiliza NovelViewModel para interactuar con los datos y configura el RecyclerView con NovelAdapter.

NovelViewModel: Actúa como intermediario entre la interfaz de usuario y los datos. Utiliza NovelRepository para acceder a los datos y proporciona métodos para insertar y eliminar novelas.

NovelRepository: Gestiona las operaciones de datos, interactuando con Firebase Firestore para realizar operaciones CRUD.

NovelLoader: Utiliza AsyncTaskLoader para cargar datos de forma asíncrona, lo que mejora el rendimiento al evitar bloquear el hilo principal.

Novel: Clase modelo que representa una novela, con propiedades como id, title, author, year, synopsis y favorite.

NovelAdapter: Adaptador para el RecyclerView que muestra la lista de novelas. Gestiona eventos como eliminar novelas y marcar como favoritas.

SyncDataTask: Extiende AsyncTask y se encarga de sincronizar los datos con Firebase Firestore en segundo plano.

SyncDataReceiver: BroadcastReceiver que recibe la notificación cuando la sincronización se completa y muestra una notificación al usuario.

SyncAlarmReceiver: Se activa mediante AlarmManager para ejecutar SyncDataTask en intervalos programados.

ConnectivityReceiver: Detecta cambios en la conectividad de red y ejecuta SyncDataTask cuando se conecta a Wi-Fi.

NotificationHelper: Clase de utilidad para mostrar notificaciones al usuario.

NetworkUtil: Proporciona métodos para verificar el estado de la red, como si está conectado a Wi-Fi.

Conclusión
La aplicación Gestor de Novelas cumple con los requisitos especificados:

Sincronización de Datos en Segundo Plano: Utiliza AsyncTask para sincronizar datos con el servidor remoto sin bloquear el hilo principal.
Notificaciones: Implementa notificaciones para informar al usuario sobre la finalización de la sincronización y otros eventos importantes.
Recepción de Broadcasts: Configura BroadcastReceiver para manejar eventos del sistema, como la conexión a Wi-Fi, y activa la sincronización cuando se cumplen ciertas condiciones.
Uso de Loaders: Utiliza AsyncTaskLoader para cargar datos de manera asíncrona y eficiente.
Manejo de Alarmas: Implementa AlarmManager para programar tareas de sincronización periódica.
