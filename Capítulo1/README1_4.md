
# Práctica 1.4 Jenkins - Jobs & Pipelines


## **Preparativos antes de crear los Jobs**

### 1. Verificar que Jenkins esté funcionando

Desde un navegador, accede a:

```
http://localhost:8080
```

Credenciales predeterminadas:

* **Usuario:** `netec`
* **Contraseña:** `Netec_123`

---

### 2. Verificar software adicional desde consola o terminal

#### Verificar Java:

```bash
java -version
javac --version
```

#### Verificar Maven:

```bash
mvn -version
```

---

## Job 1: **Estilo Libre (Freestyle Job)**

### Objetivo:

Clonar el repositorio, compilar el proyecto y mostrar el JAR generado.

### Pasos:

1. Ve a **Jenkins Dashboard > New Item**
2. Escribe un nombre como: `crud-freestyle-job`
3. Selecciona **Freestyle project**
4. Clic en **OK**

### Configuración:

* **Sección: Source Code Management**

  * Tipo: `Git`
  * Repositorio: `https://github.com/usuario/mi-repo.git`
  * Branch: `*/practica1.4/jenkins_jobs_pipelines`

* **Sección: Build**

  * Agrega un step de tipo: `Execute Windows batch command` y escribe:

```cmd
echo "Compilando proyecto con Maven"
mvn clean package

echo "Mostrando JAR generado:"
ls -lh target/*.jar
```

* **Guardar y ejecutar el Job**

---

## Resultado Esperado

La siguiente captura muestra la interfaz principal de Jenkins tras iniciar sesión como el usuario netec.Además, se confirma que Jenkins está correctamente instalado y corriendo en http://localhost:8080.

![Jenkins](../images/i4.png)

<br/>

Desde la terminal de Windows se confirma que el entorno cuenta con lo siguiente:
Java JDK 17.0.6 & Apache Maven 3.8.1. Esta configuración es imprescindible para compilar proyectos Spring Boot desde Jenkins.

![](../images/i5.png)

<br/>

La siguiente captura muestra el resultado de la ejecución del Job llamado crud-freestyle-job. Podemos observar:

* Build exitoso (ícono verde)
* Duración total: 39 segundos
* Usuario: Netec
* Código fuente clonado desde el repositorio: ttps://github.com/NetecGit/TallerDevOpsBancolombia
* Rama usada: practica1.4/jenkins_jobs_pipelines
* Último commit registrado como “Taller DevOps - commit inicial”

![Build Now](../images/i6.png)

<br/>

La siguiente captura valida que el proyecto fue compilado, probado y empaquetado exitosamente desde Jenkins mediante un job de estilo libre que ejecuta comandos Maven. Es una evidencia de que Jenkins, Java y Maven están correctamente configurados y el código fuente del caso de estudio está funcional.

![Build Now](../images/i7.png)

<br/>

---