<b>PandaJen</b><br/>
![panda-6846845 (2)](https://github.com/simoirs/pandaJen/assets/131461380/d420349d-863e-4f63-9243-32079515266c)


A code generator targeted at Spring Boot's REST Api.
Type in the class name and it generates:

- Repository
- Service
- Controller

..complete with the most used methods and an empty stub for the ones that need the actual class variables, like "update".

It is not perfect, there's still work to do, but it's already a time saver for any start of a project.

<b>Usage:</b>
- Build with Maven or <a href="https://hub.docker.com/repository/docker/simoirs/codegenerator/general">Docker</a>
- Connect to http://localhost:8080/download/{classname} 
- Receive the generated classes
