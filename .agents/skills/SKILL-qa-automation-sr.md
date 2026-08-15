# Skill: QA Automation Senior (Java, Selenium, Cucumber, TestNG & Architecture Expert)

## Propósito
Esta habilidad define las directrices arquitectónicas, mejores prácticas de programación y estándares avanzados de automatización que el rol de **QA Automation Senior** debe aplicar al diseñar, refactorizar, implementar y mantener el código del framework en Java.

---

## Principios Fundamentales y Estándares de Código

### 1. Arquitectura Page Object Model (POM) y Limpieza
- **Aislamiento de Locators:** Los localizadores de elementos web (`By` o `String` XPath) DEBEN ser privados e ingresar únicamente dentro de las clases Page Object (`pages/`).
- **Paginación Agnóstica:** Ninguna clase Page Object debe importar librerías de prueba (Cucumber o TestNG) ni realizar aserciones de prueba directas.
- **Paso Limpio en Steps:** Los archivos Step Definition (`steps/`) y clases de prueba (`tests/`) interactúan con la aplicación EXCLUSIVAMENTE llamando a métodos de las clases Page Object. Jamás deben invocar `driver.findElement()` ni usar `By.*` directamente.

### 2. Gestión de WebDriver Segura para Hilos (Thread-Safety)
- **Instanciación:** Toda obtención y gestión de `WebDriver` debe canalizarse a través de un gestor de hilos (`ThreadLocal<WebDriver>`) como `DriverManager.java`.
- **Prohibido Drivers Estáticos:** Nunca declarar el `WebDriver` como variable estática global mutable entre clases.
- **Navegadores Dinámicos:** Utilizar `WebDriverManager` para la descarga automática del driver según el navegador configurado (`config.properties`), evitando ejecutables `.exe` en disco.

### 3. Flexibilidad y Resiliencia en Localizadores y Esperas
- **Objeto `By`:** Priorizar el uso de identificadores estables (`By.id()`, `By.name()`, `By.cssSelector()`) sobre XPaths absolutos o frágiles.
- **Esperas Explícitas:** Usar siempre esperas explícitas mediante `WebDriverWait` y `ExpectedConditions`. 
- **REGLA DE ORO:** Está estrictamente PROHIBIDO el uso de esperas fijas (`Thread.sleep()`).

### 4. Centralización de Configuraciones y Cero Hardcoding
- URLs de ambiente, timeouts, navegadores y parámetros del sistema deben alojarse en `config.properties` y consumirse a través de `ConfigReader.java`.
- Datos de prueba dinámicos o complejos deben ser leídos desde los archivos de la carpeta `dataloader/` (`.csv`, `.xlsx`).

### 5. Documentación Explicativa de Código (JavaDoc Obligatorio)
- Todos los métodos creados o modificados en las clases del framework (`BasePage`, `Pages`, `Utils`, `Steps`, `Tests`) deben contar con documentación **JavaDoc detallada en español** que explique:
  - Propósito general de la función.
  - Parámetros recibidos (`@param`).
  - Valor de retorno (`@return`), si aplica.

### 6. Control del Ciclo de Vida y Reportes (Cucumber & TestNG)
- Configurar `Hooks.java` (`@Before` y `@After`) para controlar el encendido/cierre de navegadores por escenario BDD.
- En caso de fallas en pruebas UI, capturar la pantalla (`TakesScreenshot`) e incrustarla automáticamente en los reportes de Cucumber y Allure Framework.
- Para ejecuciones masivas o múltiples comprobaciones por pantalla, promover el uso de `SoftAssert` de TestNG ejecutando `assertAll()` al finalizar.

### 7. Respeto a Carpetas Locales
- Mantener la carpeta `src/test/java/varios` aislada como espacio experimental del usuario, no alterando sus utilidades a menos que se solicite explícitamente.

---

## Convenciones de Trazabilidad (Obligatorias)
Para mantener trazabilidad fuera del contexto efímero de la sesión:
- Al generar planes de implementación o walkthroughs, exportar siempre una copia al directorio `.agents/logs/`.
- Nomenclatura: `YYYY-MM-DD_Nombre-Tarea_Plan.md` y `YYYY-MM-DD_Nombre-Tarea_Walkthrough.md`.
- Mantener actualizado el archivo `CONVERSATION_HISTORY.md` en `.agents/logs/` con decisiones arquitectónicas clave.
