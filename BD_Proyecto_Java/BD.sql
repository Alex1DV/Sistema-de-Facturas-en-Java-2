CREATE DATABASE BD_PROYECTO_ESC_ALEX13
GO

USE BD_PROYECTO_ESC_ALEX13
GO

------------------------------------------------------------------------------------------------------------------------------------------------
--TABLAS (CON LLAVES FOR?NEAS) Y ALGUNAS RESTRICCIONES

CREATE TABLE USUARIO(
	NOMBRE_USUARIO VARCHAR(40) PRIMARY KEY,
	CONTRASENA INT
);

--************************************************************************************************
ALTER TABLE USUARIO                                                                            --*    
	ADD CONSTRAINT CHK_NOMBRE_U CHECK (NOMBRE_USUARIO = 'Admin' or NOMBRE_USUARIO = 'Empleado')--*
ALTER TABLE USUARIO                                                                            --*       
	ADD CONSTRAINT CHK_CONSTRASENA CHECK (CONTRASENA = 1234 or CONTRASENA = 4321)              --*
--************************************************************************************************

CREATE TABLE PROVEEDOR(
	NUM_PROVEEDOR INT PRIMARY KEY,
	NOMBRE_ORG VARCHAR(500) NOT NULL,
	CORREO VARCHAR(100) NOT NULL,
	DIRECCION VARCHAR(500) NOT NULL,
	TELEFONO VARCHAR(100)
);

--SELECT * FROM PROVEEDOR

CREATE TABLE PRODUCTO(
	NUMERO_PRODUCTO INT PRIMARY KEY,
	NOMBRE_PRODUCTO VARCHAR(200) NOT NULL,
	TIPO_PRODUCTO VARCHAR(150) NOT NULL,
	PRECIO_VENTA FLOAT NOT NULL,
	CANTIDAD INT NOT NULL,
	IMPUESTO FLOAT DEFAULT 13.00,
	DESCUENTO INT NOT NULL,
	DESCRIPCION VARCHAR(300) NOT NULL,
	GARANTIA VARCHAR(15) NOT NULL,
	DISPONIBILIDAD VARCHAR(15) NOT NULL,
	NUM_PROVEEDOR INT REFERENCES PROVEEDOR(NUM_PROVEEDOR)
);

--SELECT * FROM PRODUCTO

--*********************************************************
ALTER TABLE PRODUCTO                                    --*
	ADD CONSTRAINT CHK_PRECIO_V CHECK (PRECIO_VENTA > 0)--*
ALTER TABLE PRODUCTO
	ADD PRECIO_COMPRA FLOAT NULL
ALTER TABLE PRODUCTO
	ADD PRECIO_TOTAL FLOAT NULL
--*********************************************************

CREATE TABLE TRABAJADOR(
	ID_TRABAJADOR INT PRIMARY KEY,
	NOMBRE VARCHAR(200) NOT NULL,
	APELLIDOS VARCHAR(400) NOT NULL,
	TELEFONO VARCHAR(200) NOT NULL,
	RESIDENCIA VARCHAR(700) NOT NULL
);

--SELECT * FROM TRABAJADOR

CREATE TABLE ORDENES_DE_COMPRA(
	NUMERO_ORDEN INT PRIMARY KEY,
	NUMERO_PRODUCTO INT REFERENCES PRODUCTO(NUMERO_PRODUCTO),
	NUM_PROVEEDOR INT REFERENCES PROVEEDOR(NUM_PROVEEDOR),
	NOMBRE_PRODUCTO VARCHAR(200) NOT NULL,
	FECHA_ORDEN_PEDIDO Date,
	FECHA_RECIBIDA_PEDIDO Date,
	PRECIO_X_UNIDAD FLOAT NOT NULL,
	IMPUESTO FLOAT DEFAULT 13.00,
	TOTAL_A_PAGAR FLOAT NOT NULL,
	ID_TRABAJADOR INT REFERENCES TRABAJADOR(ID_TRABAJADOR)
);

--SELECT * FROM ORDENES_DE_COMPRA

--***************************************************************
ALTER TABLE ORDENES_DE_COMPRA                                 --*
	ADD CONSTRAINT CHK_PRECIO_U CHECK (PRECIO_X_UNIDAD > 0)   --*
ALTER TABLE ORDENES_DE_COMPRA                                 --* 
	ADD CONSTRAINT CHK_TOTAL CHECK (TOTAL_A_PAGAR > 0)        --*
ALTER TABLE ORDENES_DE_COMPRA
	ADD CANTIDAD INT NULL
ALTER TABLE ORDENES_DE_COMPRA
	DROP COLUMN FECHA_RECIBIDA_PEDIDO 

--***************************************************************

--SELECT * FROM ORDENES_DE_COMPRA

--CREATE TABLE DETALLE_ORDEN(
--	NUMERO_ORDEN INT NOT NULL,
--	NUMERO_PRODUCTO INT NOT NULL,
--	NOMBRE_PRODUCTO VARCHAR(500) NOT NULL,
--	CONSTRAINT PK_DETALLE_ORDEN PRIMARY KEY (NUMERO_ORDEN,NUMERO_PRODUCTO)
--);



CREATE TABLE CLIENTE(
	ID_CLIENTE INT PRIMARY KEY,
	NOMBRE VARCHAR(200) NOT NULL,
	APELLIDOS VARCHAR(400) NOT NULL,
	TELEFONO VARCHAR(200) NOT NULL,
	RESIDENCIA VARCHAR(700) NOT NULL,
	
);

--SELECT * FROM CLIENTE

CREATE TABLE ENCABEZADO_FACTURA(
	NUMERO_FACTURA INT PRIMARY KEY,
	ID_TRABAJADOR INT REFERENCES TRABAJADOR(ID_TRABAJADOR),
	FECHA DATE DEFAULT GETDATE(), 
	SUBTOTAL FLOAT NOT NULL,
	IMPUESTO INT DEFAULT 13.00,
	DESCUENTO INT NOT NULL,
	MONTO_A_PAGAR FLOAT NOT NULL,
);

--	SELECT * FROM ENCABEZADO_FACTURA
--	SELECT * FROM DETALLES_FACTURA

--Select * from producto
--********************************************************
   --*  
ALTER TABLE ENCABEZADO_FACTURA                         --*
	ADD CONSTRAINT CHK_MONTO CHECK(MONTO_A_PAGAR > 0)  --*
ALTER TABLE ENCABEZADO_FACTURA 
	ALTER COLUMN FECHA DATE NULL
ALTER TABLE ENCABEZADO_FACTURA
	ADD ID_CLIENTE INT REFERENCES CLIENTE(ID_CLIENTE) NULL
ALTER TABLE ENCABEZADO_FACTURA 
	ALTER COLUMN DESCUENTO FLOAT NOT NULL
ALTER TABLE ENCABEZADO_FACTURA
	DROP COLUMN SUBTOTAL

ALTER TABLE ENCABEZADO_FACTURA
	DROP COLUMN DESCUENTO
--********************************************************

CREATE TABLE DETALLES_FACTURA(
	NUMERO_FACTURA INT NOT NULL,
	NUMERO_PRODUCTO INT NOT NULL,
	NOMBRE_PRODUCTO VARCHAR(500) NOT NULL, 
	CANTIDAD_COMPRADA INT NOT NULL,
	FECHA_LIMITE_GARANTIA DATE NOT NULL
	CONSTRAINT PK_DETALLES_FACTURA PRIMARY KEY (NUMERO_FACTURA,NUMERO_PRODUCTO)
);

--insert into DETALLES_FACTURA(NUMERO_FACTURA,NUMERO_PRODUCTO,NOMBRE_PRODCUTO,CANTIDAD_COMPRADA) values
--(1,1,'Camisa',2);


--SELECT * FROM DETALLES_FACTURA


--SELECT NUMERO_FACTURA,NUMERO_PRODUCTO,NOMBRE_PRODCUTO,CANTIDAD_COMPRADA,GARANTIA from DETALLES_FACTURA where  
--Numero_producto = 3

--****************************************************************************
ALTER TABLE DETALLES_FACTURA                                               --*
	ADD CONSTRAINT CHK_CANTIDAD CHECK (CANTIDAD_COMPRADA > 0)              --*
																		   --*
ALTER TABLE DETALLES_FACTURA ADD CONSTRAINT FK_DETALLE_FACTURA             --*
FOREIGN KEY (NUMERO_PRODUCTO) REFERENCES PRODUCTO(NUMERO_PRODUCTO)            --*
                                                                           --*
ALTER TABLE DETALLES_FACTURA ADD CONSTRAINT FK_DETALLE_FACTURA_ENCABEZADO  --*
FOREIGN KEY (NUMERO_FACTURA) REFERENCES ENCABEZADO_FACTURA(NUMERO_FACTURA)     --*
ON DELETE CASCADE                                                          --*
ON UPDATE CASCADE                                                          --*
                                                                           --*
ALTER TABLE DETALLES_FACTURA 
	ALTER COLUMN FECHA_LIMITE_GARANTIA DATE NULL
ALTER TABLE DETALLES_FACTURA 
	ADD NOMBRE_PRODCUTO VARCHAR(500) NOT NULL
ALTER TABLE DETALLES_FACTURA
	DROP COLUMN FECHA_LIMITE_GARANTIA

ALTER TABLE DETALLES_FACTURA 
	ADD GARANTIA VARCHAR(500)  NULL
ALTER TABLE DETALLES_FACTURA
	DROP COLUMN NOMBRE_PRODCUTO
ALTER TABLE DETALLES_FACTURA 
	ADD PRECIO FLOAT  NULL

	--SELECT * FROM DETALLES_FACTURA
--****************************************************************************

CREATE TABLE DEVOLUCIONES_VENTAS(
	NUMERO_DEVOLUCION INT PRIMARY KEY,
	NUMERO_FACTURA INT REFERENCES ENCABEZADO_FACTURA(NUMERO_FACTURA),
	FECHA_REALIZACION DATE DEFAULT GETDATE(),
	FECHA_LIMITE_GARANTIA DATE,
	MOTVO_DEVOLUCION VARCHAR(500) NOT NULL,
	ACEPTACION_DEVOLUCION VARCHAR(10) NOT NULL,
	ID_TRABAJADOR INT REFERENCES TRABAJADOR(ID_TRABAJADOR),
);

ALTER TABLE DEVOLUCIONES_VENTAS
	ADD NUMERO_PRODUCTO INT NULL

--SELECT * FROM DEVOLUCIONES_VENTAS
--SELECT * FROM DETALLES_FACTURA
--SELECT * FROM ENCABEZADO_FACTURA
--SELECT * FROM ORDENES_DE_COMPRA



CREATE TABLE ORDENES_DE_COMPRA2(
	NUMERO_ORDEN INT PRIMARY KEY,
	NUM_PROVEEDOR INT REFERENCES PROVEEDOR(NUM_PROVEEDOR),
	FECHA_ORDEN_PEDIDO Date,
	IMPUESTO FLOAT DEFAULT 13.00,
	TOTAL_A_PAGAR FLOAT NOT NULL,
	ID_TRABAJADOR INT REFERENCES TRABAJADOR(ID_TRABAJADOR)
);
CREATE TABLE DETALLES_COMPRA(
	NUMERO_ORDEN INT,
	NUMERO_PRODUCTO INT,
	NOMBRE_PRODUCTO VARCHAR(500) NOT NULL,
	CANTIDAD INT NOT NULL,
	CONSTRAINT PK_DETALLES_COMPRA PRIMARY KEY (NUMERO_ORDEN,NUMERO_PRODUCTO)

);
-----------------------------------------------------------------------------------------------------------------------------------------------
--+
--SELECT * FROM ENCABEZADO_FACTURA
--SELECT * FROM PRODUCTO

CREATE OR ALTER TRIGGER TR_VENTA_ACT
ON DETALLES_FACTURA
FOR UPDATE
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD_X INT
DECLARE @NUM_FACT INT
DECLARE @NUM_P INT
DECLARE @PRECIO FLOAT
DECLARE @CANTIDAD_R INT

SELECT @CANTIDAD_X=CANTIDAD_COMPRADA FROM inserted
SELECT @NUM_P = NUMERO_PRODUCTO FROM inserted
SELECT @NUM_FACT = NUMERO_FACTURA FROM inserted
SELECT @PRECIO = PRECIO FROM inserted
SELECT @CANTIDAD_R = @CANTIDAD_R - CANTIDAD_COMPRADA FROM inserted



 UPDATE ENCABEZADO_FACTURA
 
 SET MONTO_A_PAGAR= @CANTIDAD_X * @PRECIO
 WHERE NUMERO_FACTURA=@NUM_FACT 
 
 GO
 
 SELECT * FROM ENCABEZADO_FACTURA
--update detalles_factura
--set numero_factura = 7
--set numero_producto = 4 
--set nombre_producto = 'Pelotas de Tennis'
--set cantidad_comprada = 3
--set garantia = 'No Aplica'


CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICAR_DETALLES_FACTURA( @NUMERO_FACTURA INT,
											  @NUMERO_PRODUCTO INT,	
											  @NOMBRE_PRODUCTO VARCHAR(500),
											  @CANTIDAD_COMPRADA INT,
											  @GARANTIA VARCHAR(100),
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
			BEGIN
				IF(EXISTS(SELECT * FROM DETALLES_FACTURA WHERE NUMERO_FACTURA=@NUMERO_FACTURA AND NUMERO_PRODUCTO=@NUMERO_PRODUCTO AND 
				NOMBRE_PRODUCTO=@NOMBRE_PRODUCTO AND CANTIDAD_COMPRADA=@CANTIDAD_COMPRADA AND GARANTIA = @GARANTIA))
				
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	END
GO



CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICAR_DETALLES_FACTURA( @NUMERO_FACTURA INT,
											  @NUMERO_PRODUCTO INT,	
											  @NOMBRE_PRODUCTO VARCHAR(500),
											  @CANTIDAD_COMPRADA INT,
											  @GARANTIA VARCHAR(100),
											  @precio float,
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
			BEGIN
				IF(EXISTS(SELECT * FROM DETALLES_FACTURA WHERE NUMERO_FACTURA=@NUMERO_FACTURA AND NUMERO_PRODUCTO=@NUMERO_PRODUCTO AND 
				NOMBRE_PRODUCTO=@NOMBRE_PRODUCTO AND CANTIDAD_COMPRADA=@CANTIDAD_COMPRADA AND GARANTIA = @GARANTIA AND PRECIO = @precio))
				
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	END
GO


