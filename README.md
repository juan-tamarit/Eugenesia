# Eugenesia

> Plataforma experimental para la evolución genética de personajes inspirados en Dungeons & Dragons y la evaluación de estrategias de Inteligencia Artificial.

---

# Objetivo del proyecto

Eugenesia busca construir un entorno de simulación donde:

* Los personajes se generan automáticamente mediante algoritmos genéticos.
* Los equipos se forman de manera dinámica.
* Los combates se resuelven mediante un motor determinista.
* Distintas inteligencias artificiales pueden controlar a los personajes.
* Cada simulación produce datos que posteriormente pueden analizarse estadísticamente.

El proyecto combina ingeniería de software, algoritmos genéticos, simulación de combates y evaluación de modelos de IA.

---

# Arquitectura general

```text
eugenesia/
│
├── engine/
├── simulation/
├── api/
├── frontend/
├── configs/
├── outputs/
├── docs/
└── README.md
```

---

# Módulos del proyecto

## engine/ (Java)

**El motor del proyecto.**

Aquí vive toda la lógica del mundo.

Responsabilidades:

* Modelo de personajes.
* Estadísticas (STR, DEX, CON, INT, WIS, CHA).
* Sistema de combate.
* Formación de equipos.
* Algoritmo genético.
* Evolución de poblaciones.
* Gestión de torneos.
* IA de los personajes.
* Exportación de resultados.

El motor recibe una configuración de simulación y genera un resultado.

**No conoce Python, React ni FastAPI.**

---

## simulation/ (Python)

**El laboratorio del proyecto.**

Su función no es simular combates, sino experimentar con ellos.

Responsabilidades:

* Ejecutar simulaciones masivas.
* Automatizar experimentos.
* Analizar resultados.
* Comparar configuraciones.
* Generar estadísticas.
* Crear gráficas.
* Realizar análisis exploratorios mediante notebooks.

Aquí viven herramientas como:

* pandas
* numpy
* matplotlib
* Jupyter Notebooks

---

## api/ (FastAPI)

**El puente entre el motor y el frontend.**

Responsabilidades:

* Lanzar nuevas simulaciones.
* Ejecutar el motor Java.
* Leer los resultados generados.
* Exponer una API REST para el frontend.

El frontend nunca accede directamente al motor Java.

---

## frontend/ (React + Vite)

**La interfaz visual del proyecto.**

Su objetivo es permitir explorar las simulaciones de forma sencilla.

Permitirá:

* Crear nuevas simulaciones.
* Consultar simulaciones anteriores.
* Ver personajes generados.
* Visualizar equipos.
* Seguir el desarrollo del torneo.
* Consultar clasificaciones.
* Mostrar estadísticas y gráficos.

No contiene ninguna lógica del juego.

Solo representa información.

---

## configs/

Configuraciones de las simulaciones.

Ejemplos:

* Tamaño de la población.
* Número de generaciones.
* Probabilidad de mutación.
* Tipo de torneo.
* Modelo de IA utilizado.
* Parámetros del combate.

Modificar estos archivos debe permitir ejecutar distintos experimentos sin cambiar código.

---

## outputs/

Resultados generados por las simulaciones.

Cada simulación podrá almacenar:

* Configuración utilizada.
* Personajes generados.
* Equipos formados.
* Registro de combates.
* Clasificación final.
* Estadísticas.
* Métricas del algoritmo genético.

Este directorio representa el histórico del proyecto.

---

## docs/

Documentación técnica.

Contendrá:

* Diagramas UML.
* Diagramas de arquitectura.
* Decisiones de diseño.
* Roadmap.
* Ideas futuras.
* Documentación técnica.

---

# Flujo general del sistema

```text
             React
               │
          HTTP (REST)
               │
           FastAPI
               │
      -------------------
      │                 │
 Java Engine     Python Analysis
      │
 results.json
```

1. El usuario crea una simulación desde el frontend.
2. FastAPI recibe la petición.
3. FastAPI ejecuta el motor Java.
4. El motor genera toda la simulación.
5. Los resultados se almacenan en `outputs/`.
6. Python puede analizarlos posteriormente.
7. FastAPI devuelve la información al frontend.

---

# Filosofía del proyecto

Cada módulo tiene una única responsabilidad.

* **Java** crea y simula el mundo.
* **Python** analiza el mundo.
* **FastAPI** conecta los módulos.
* **React** muestra el resultado al usuario.

Mientras esta separación se mantenga, el proyecto será fácil de mantener y ampliar.

---

# Roadmap

## Fase 0 — Arquitectura

* Estructura del repositorio.
* Configuración inicial.
* UML.
* Contratos JSON.

## Fase 1 — Motor

* Personajes.
* Combate.
* Equipos.
* IA básica.

## Fase 2 — API

* Integración con FastAPI.
* Lanzamiento de simulaciones.

## Fase 3 — Frontend

* Dashboard.
* Personajes.
* Equipos.
* Torneos.

## Fase 4 — Evolución genética

* Poblaciones.
* Selección.
* Cruce.
* Mutación.
* Evaluación de individuos.
* Evolución de generaciones.

## Fase 5 — Análisis

* Estadísticas.
* Gráficas.
* Comparativas.

## Fase 6 — Experimentación con IA

* Formalización del `BattleState`.
* Separación entre selección de objetivo y selección de acción.
* Estrategia basada en reglas.
* Agentes basados en ML/DL.
* Agentes basados en LLM.
* Comparación de estrategias.
* Evaluación de rendimiento, coste y eficiencia.

---

# Si vuelvo al proyecto dentro de seis meses...

Solo necesito recordar cuatro ideas:

* **Java** → Aquí vive el mundo.
* **Python** → Aquí investigo el mundo.
* **FastAPI** → Aquí conecto las piezas.
* **React** → Aquí visualizo el mundo.

Si estas cuatro responsabilidades permanecen separadas, cualquier nueva funcionalidad tendrá un lugar claro donde implementarse.
