# Historial de Conversaciones y Decisiones de Diseño: FrameworkSelenium

Este archivo sirve como bitácora y diario de ingeniería continuo para registrar resúmenes, discusiones de chat, respuestas a consultas y decisiones de diseño acordadas en el proyecto `FrameworkSelenium`.

---

## Sesión: Configuración de Subagentes (Analista QA y QA Automation Senior)
**Fecha:** 26 de Julio de 2026  
**Objetivo:** Implementar la arquitectura de 2 subagentes especializados (inspirada en la metodología de agilidad e IA para QA de *Calidad sin Humo*) dentro del entorno Antigravity para el proyecto `FrameworkSelenium`.

### 1. Definición de Roles y Skills
Se crearon y actualizaron dos habilidades (*skills*) principales en la carpeta `.agents/skills/`:

1. **Analista QA (`qa-analyst/SKILL.md`):**
   - **Enfoque:** Análisis de negocio, desglose de historias de usuario, identificación de riesgos/ambigüedades, definición de criterios de aceptación y generación de escenarios Gherkin (`.feature`) bajo sintaxis BDD (`Given / When / Then`).
   - **Restricción:** No escribe código Java ni interactúa con Selenium/WebDrivers.

2. **QA Automation Senior (`qa-automation-senior/SKILL.md`):**
   - **Enfoque:** Arquitectura de automatización de alto nivel en Java, Selenium WebDriver, Cucumber BDD, TestNG y Page Object Model (POM).
   - **Estándares:** 
     - Thread-Safety mediante `DriverManager` (`ThreadLocal<WebDriver>`).
     - Encapsulamiento de locators en clases `pages/` usando objetos `By`.
     - Esperas explícitas exclusivas (`WebDriverWait`), prohibiendo `Thread.sleep()`.
     - Centralización de propiedades en `config.properties` y `ConfigReader`.
     - Documentación JavaDoc obligatoria en español para todos los métodos.
     - Reportes gráficos con capturas automáticas en fallas (Hooks y Allure Framework).

---

### 2. Flujo de Trabajo Integrado en Antigravity
- Se estableció que **el chat principal funciona como el Orquestador QA**.
- No se requiere abrir chats ni ventanas múltiples. Al solicitar una nueva prueba o funcionalidad, el orquestador invoca en segundo plano al **Analista QA** para diseñar los `.feature` y posteriormente al **QA Automation Senior** para implementar las clases Java correspondientes.

---
*(Fin de la sesión del 2026-07-26. Anexar nuevas conversaciones y avances a continuación)*
