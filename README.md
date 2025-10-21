# 🎃 Túnel del Terror → Ruleta TRUCO / TRATO 👻
Mini aplicación JavaFX inspirada en Halloween.  
Proyecto evaluable del **Módulo 5 (Interfaces)**.

---

## 🧩 Descripción
Esta aplicación simula una pequeña experiencia de Halloween en dos fases:

1. **Pantalla de Entrada al Túnel:**  
   El usuario introduce su **nombre**, **apellidos** y **curso** (DAM, DAW o SMR).  
   Si los datos son válidos, puede entrar al túnel... ¡si se atreve! 👀

2. **Pantalla de la Ruleta TRUCO/TRATO:**  
   Una ruleta animada gira y se detiene mostrando aleatoriamente un resultado:  
   **🎭 TRUCO** o **🍬 TRATO**, con mensajes temáticos personalizados.  
   Se muestra en pantalla el nombre completo y el curso del usuario.

---

## ⚙️ Funcionalidades principales

### 🕸️ Pantalla 1 — Entrada al Túnel
- Campos de texto para **Nombre** y **Apellidos**.  
- **ComboBox** con cursos disponibles (DAM1, DAM2, DAW1, DAW2, SMR1, SMR2).  
- Botón **"Entrar si te atreves"** con validación:
  - No permite continuar si hay campos vacíos.
  - Muestra mensajes claros y breves.
- Estética Halloween (colores oscuros, tipografía temática, fondo decorativo).

### 🧙‍♀️ Pantalla 2 — Ruleta TRUCO/TRATO
- **Animación de giro** de la ruleta (Canvas o imagen rotatoria).
- Resultado aleatorio 50/50 entre TRUCO y TRATO.
- Mensaje final temático según el resultado.
- Desactivación del botón **GIRAR** durante el giro.
- Transferencia del nombre y curso desde la primera pantalla.

---

## 🧠 Requisitos técnicos
- **JavaFX + Scene Builder**
- Controladores:
  - `EntradaTunel.java`
  - `RuletaTrucoTrato.java`
- Ficheros FXML:
  - `entrada.fxml`
  - `ruleta.fxml`
  -  Hoja de estilos `halloween.css` para personalización visual.


---


  
