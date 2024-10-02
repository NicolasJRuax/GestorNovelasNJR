# Gestión de Novelas

## Descripción

Gestión de Novelas es una aplicación Android diseñada para ayudar a los usuarios a gestionar su colección de novelas. Permite a los usuarios agregar, editar, eliminar y visualizar detalles de cada novela. La aplicación está construida utilizando **Android Room** para la gestión de la base de datos y **LiveData** para actualizar automáticamente la interfaz de usuario cuando los datos cambian.

## Funcionalidades

- **Agregar Novelas**: Los usuarios pueden agregar nuevas novelas ingresando el título, autor, año de publicación y una sinopsis.
- **Eliminar Novelas**: Permite eliminar novelas de la colección con confirmación.
- **Ver Detalles**: Los usuarios pueden ver detalles completos de cada novela, incluyendo título, autor, año y sinopsis.
- **Lista de Novelas**: Las novelas se presentan en un formato de lista que permite un acceso fácil a cada título.

## Tecnologías Utilizadas

- **Android**: SDK de Android para el desarrollo móvil.
- **Room**: Biblioteca de Android para la persistencia de datos.
- **LiveData**: Componentes de arquitectura de Android para la gestión de datos observables.
- **RecyclerView**: Componente de Android para mostrar listas de elementos de manera eficiente.

## Estructura del Proyecto

- **MainActivity**: Punto de entrada de la aplicación, maneja la interacción del usuario y muestra la lista de novelas.
- **Novel**: Clase que representa la entidad de una novela en la base de datos.
- **NovelDao**: Interfaz que define las operaciones CRUD para la entidad Novel.
- **NovelRepository**: Clase que encapsula la lógica de acceso a datos y gestiona las interacciones con la base de datos.
- **NovelViewModel**: Clase que actúa como intermediario entre el UI y el repositorio de datos, gestionando el ciclo de vida de los datos.
- **NovelAdapter**: Adaptador para el RecyclerView que maneja la visualización de cada novela en la lista.
