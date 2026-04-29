# INF5150 - Unidad 07  
## Interfaces gráficas en Java (Swing) con arquitectura y pruebas unitarias  

![Java](https://img.shields.io/badge/Java-24-blue)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![UI](https://img.shields.io/badge/UI-FlatLaf-orange)
![Build](https://github.com/edjnolasco/INF5150-U07/actions/workflows/ci.yml/badge.svg)
![Coverage](https://codecov.io/gh/edjnolasco/INF5150-U07/branch/main/graph/badge.svg)

**Autor:** Edwin José Nolasco  

---

## 📌 Descripción

Este repositorio implementa la Unidad 07 de INF5150, enfocada en el desarrollo de interfaces gráficas en Java con Swing, incorporando principios fundamentales de arquitectura de software.

Incluye:

- separación UI / lógica de negocio  
- validación centralizada  
- servicios y entidades  
- pruebas unitarias (JUnit 5)  
- interfaz moderna con FlatLaf (modo claro/oscuro)  

---

## 🎥 Demo

![Demo](assets/screenshots/demo.gif)

---

## 🧠 Arquitectura

```
UI (Swing)
   ↓
Controladores (eventos)
   ↓
Servicios / Validadores
   ↓
Entidades / Datos
```

---

## 🎛️ Dashboard

Ejecutar:

```bash
mvn exec:java -Dexec.mainClass="ui.AppLauncher"
```

Características:

- dashboard centralizado  
- navegación entre ejercicios  
- modo claro/oscuro dinámico  
- UI moderna  

---

## 🖼️ Vista del sistema

### Dashboard
![Dashboard](assets/screenshots/dashboard.png)

### Tabla de estudiantes
![Tabla](assets/screenshots/tabla.png)

### Inventario
![Inventario](assets/screenshots/inventario.png)

### Modo oscuro
![Dark](assets/screenshots/darkmode.png)

---

## 📚 Contenidos

| Unidad | Tema |
|------|------|
| UT01 | Ventana básica |
| UT02 | Eventos |
| UT03 | Validación |
| UT04 | Cálculo |
| UT05 | CRUD |
| UT06 | Navegación |
| UT07 | Árbol |
| UT08 | RadioButton |
| UT09 | CheckBox |
| UT10 | ComboBox |
| UT11 | JTable |

---

## ⚙️ Tecnologías

- Java 24  
- Swing  
- Maven  
- JUnit 5  
- FlatLaf  

---

## 🧪 Pruebas

```bash
mvn test
```

Resultado esperado:

```
Tests run: 27, Failures: 0, Errors: 0
BUILD SUCCESS
```

---

## ▶️ Ejecución

```bash
mvn compile
mvn exec:java -Dexec.mainClass="ui.AppLauncher"
```

---

## ⚠️ Notas

- ventanas usan `DISPOSE_ON_CLOSE`  
- launcher controla ciclo de vida  
- lógica desacoplada de UI  

---

## 🎯 Conclusión

Este proyecto demuestra la transición desde interfaces básicas hacia una arquitectura estructurada, testeable y mantenible en Java.
