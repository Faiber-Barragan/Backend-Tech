# 🏪REST API - Tech - Accenture🏪
*Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el cliente selecciona los productos a comprar con un valor mayor de 70.000 pesos entonces el sistema genera la factura con el iva (Impuesto del 19%) y el valor del domicilio.

*Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el cliente selecciona los productos a comprar con un valor mayor de 100.000 pesos entonces el sistema genera la factura con el iva (Impuesto del 19%) y el valor del domicilio en 0 pesos.

*Dado que un cliente quiere editar su pedido cuando no han trascurrido más de 5 horas entonces el sistema debe dejarlo editar si los productos seleccionados cuestan igual o más que los anteriores.

*Dado que un cliente quiere agregar a su pedido un nuevo producto cuando el pedido era por valor de 70 mil pesos y al agregar el nuevo producto el pedido pasa de 100 mil pesos entonces el sistema debe de restar el valor del domicilio.

*Dado que un cliente quiere eliminar su pedido cuando no han pasado más de 12 horas entonces el sistema debe dejarlo eliminar.

*Dado que un cliente quiere eliminar su pedido cuando han pasado más de 12 horas entonces el sistema debe de facturarle el 10% del valor del pedido y cancelar el pedido.


## 🔧 Requirements
That version or above
```	
<properties>
	<java.version>11</java.version>
</properties>
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<scope>runtime</scope>
		<optional>true</optional>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>
```

## 📦 Installation
```
gh repo clone Faiber-Barragan/Backend-Tech-Accenture
Install Spring Tool Suite 4
Execute proyect like Spring Boot App and Java 11 or higher

```

## 📝 Documentation
```
The web services used in this application are described in https://documenter.getpostman.com/view/3388013/TzCV4QRt
```

## 🚀 Deploy
```
Deploying with Heroku: https://store302.herokuapp.com/
```

## 💻 Team

| ![https://github.com/Faiber-Barragan](https://avatars.githubusercontent.com/u/61174815?s=400&u=f2d89be9d59531880646203e6fa92c328197d72b&v=4) <br/> [@faiber-barragan](https://github.com/Faiber-Barragan) <br/> Developer |
|:-:|

- Faiber Alberto Barragán Vergara:octocat: [@faiber-barrragan](https://github.com/Faiber-Barragan)

