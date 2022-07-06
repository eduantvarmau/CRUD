# Proyecto Spring

### Acerca de:
Esta app despliega servicios de tipo `REST` de manera local.

### Requisitos:

* Hacer uso de la base de datos `H2`
* Consumir la DB http://localhost:8080/h2

### Ejecucion:
Ejecutar el archivo "Main" 

### Endpoints:
* `GET` "/employee/employeeList": Lista de empleados.
* `GET` "/employee/employeeDetails/{id}": Datos del empleado correspondiente a su id.
* `DELETE` "/employee/employeeDelete/{id}": Elimina los datos del empleado correspondiente a su id.
* `PUT` "/employee/employeeUpdate/{id}": Modifica los datos del empleado correspondiente a su id, los nuevos datos deben ingresarse en formato JSON en el cuerpo de la petición.
* `POST` "/employee/apiv1/clientes/add": Inserta los datos de un nuevo empleado. Los datos deben agregarse en formato JSON en el cuerpo de la petición.

### Formato JSON:
Si desea agregar datos al JSON, utilice el siguiente formato:

{
"firstname" : "example",
"surname" : "example",
"country" :
{"name" : "example,
"airports" : [
{"name" : "example"}
]
},
"likedLanguages" : [
{"name" : "example"}
]
}

