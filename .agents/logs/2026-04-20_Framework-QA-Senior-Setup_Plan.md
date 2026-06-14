# Organización del Framework QA Automation Senior y Establecimiento de Skills de IA

El objetivo es analizar el framework actual (Selenium, Java, Cucumber, TestNG y Page Object Model), implementar una "Habilidad/Skill" de `qa-automation-senior` para que el agente de IA la siga, y establecer un diario de ingeniería guardando los planes y explicaciones (walkthroughs) directamente dentro del repositorio del proyecto.

## Revisión del Framework
He analizado tu proyecto `FrameworkSelenium`. Actualmente, sigue una buena estructura de Page Object Model y BDD (Cucumber) con:
- `BasePage` que maneja la inicialización del WebDriver (usando WebDriverManager) y las interacciones comunes.
- Archivos `.feature` que se mapean a los Step Definitions (como `FreeRangeNavega`).
- La carpeta `varios` contiene recursos y herramientas para agregar, así como muchas subcarpetas (`clase09`, `clase10`, etc.) derivadas de otras prácticas.

## Cambios Propuestos

### 1. Implementación de Skills del Agente
Vamos a crear una estructura de diseño "Skill" para que, en el futuro, la Inteligencia Artificial tenga instrucciones claras y precisas sobre cómo actuar como un QA Automation Senior al tocar el código de este proyecto.

#### [NUEVO] `d:\DRIVE\15-WORKSPACE - ESTUDIO - DATOS\IdeaProjects\FrameworkSelenium\.agents\skills\qa-automation-senior\SKILL.md`
Este archivo definirá cómo asumo la personalidad de `qa-automation-senior`. Incluirá:
- Instrucciones obligatorias de siempre abstraer elementos con Page Object Model.
- Reglas sobre la correcta utilización de soft assertions y hard assertions.
- Mandatos para encapsular localizadores (locators) y jamás exponer su uso directo en las clases Step Definitions.
- Directivas firmes para guardar los logs de planificación y ejecución en `.agents/logs/`.

### 2. Diario de Ingeniería (Persistencia de Logs)
#### [NUEVO] `d:\DRIVE\15-WORKSPACE - ESTUDIO - DATOS\IdeaProjects\FrameworkSelenium\.agents\logs\`
Siguiendo tus requerimientos, todos los documentos funcionales generados serán mantenidos explícitamente en modo de bitácora/log. Para esta tarea en particular, guardaremos:
- `2026-04-20_Framework-QA-Senior-Setup_Plan.md` (Una copia de este mismo plan)
- `2026-04-20_Framework-QA-Senior-Setup_Walkthrough.md` (Un informe completo post-ejecución)

### 3. Mejoras de Escalabilidad y Reutilización del Framework
Para trabajar genuinamente como un rol Senior, propondré la introducción e integración de prácticas de nivel escalable:
- **Estrategias de Tiempo de Espera (Waits)**: Refinar tu `BasePage.java` para que los tiempos de espera explícitos sean configurables centralizadamente, y no fijos en "5 segundos".
- **Manejo de Entornos (Environment Variables)**: Configuraremos una clase lectora de `config.properties` en `utils`. Esto evita dejar variables estáticas en duro (ejemplo, `www.freerangetesters.com`) sueltas en cada código (StepDefinitions o Utils).
- **Manejo de Ganchos (Hooks)**: Armaremos/mejoraremos `Hooks.java` de Cucumber para que limpie tu sesión por escenario de forma eficiente en las caídas o cierres, pudiendo adjuntar capturas de pantalla si una aserción falla.
