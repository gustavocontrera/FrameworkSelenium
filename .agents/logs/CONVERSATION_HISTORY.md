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

---

## Sesión: Propuesta de Nomenclatura para Skills y Regla de Registro
**Fecha:** 14 de Agosto de 2026  
**Objetivo:** Definir la convención de nombres preferida para las habilidades (*skills*) de los subagentes y establecer la regla de registro obligatorio en la bitácora.

### 1. Nomenclatura y Estructura Simplificada
Se simplificó la estructura ubicando ambos archivos directamente en la carpeta `.agents/skills/` sin subcarpetas innecesarias:
- **Analista QA:** [.agents/skills/SKILL-qa-analyst.md](file:///d:/DRIVE/15-WORKSPACE%20-%20ESTUDIO%20-%20DATOS/IdeaProjects/FrameworkSelenium/.agents/skills/SKILL-qa-analyst.md)
- **QA Automation Senior:** [.agents/skills/SKILL-qa-automation-sr.md](file:///d:/DRIVE/15-WORKSPACE%20-%20ESTUDIO%20-%20DATOS/IdeaProjects/FrameworkSelenium/.agents/skills/SKILL-qa-automation-sr.md)

### 2. Regla de Registro Continuo
- Se formalizó la regla en [.agents/AGENTS.md](file:///d:/DRIVE/15-WORKSPACE%20-%20ESTUDIO%20-%20DATOS/IdeaProjects/FrameworkSelenium/.agents/AGENTS.md) para actualizar obligatoriamente esta bitácora al finalizar o completar tareas.




