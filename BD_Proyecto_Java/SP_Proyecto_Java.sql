---------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_C(
	
	@IDENTIFICACION_C INT out,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM CLIENTE  
	WHERE ID_CLIENTE = @IDENTIFICACION_C ))
		BEGIN
			SET @MSJ = 'No puede insertar un cliente que ya existe, por favor aprete el botón MODIFICAR'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes(
	
	@NUM_P INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM PROVEEDOR 
	WHERE NUM_PROVEEDOR = @NUM_P ))
		BEGIN
			SET @MSJ = 'El proveedor no existe, ingréselo'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
-------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes_C(
	
	@NUM_C INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM CLIENTE
	WHERE ID_CLIENTE = @NUM_C ))
		BEGIN
			SET @MSJ = 'El cliente no existe, ingréselo'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
-------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes_T(
	
	@NUM_T INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM TRABAJADOR
	WHERE ID_TRABAJADOR = @NUM_T ))
		BEGIN
			SET @MSJ = 'El trabajador no existe, ingréselo'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
-------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes_OR(
	
	@NUM_O INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM ORDENES_DE_COMPRA
	WHERE NUMERO_ORDEN = @NUM_O ))
		BEGIN
			SET @MSJ = 'El la orden de compra no existe, ingrésela'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
-------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes_DV(
	
	@NUM_D INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM DEVOLUCIONES_VENTAS
	WHERE NUMERO_DEVOLUCION = @NUM_D ))
		BEGIN
			SET @MSJ = 'La devolución no existe, ingrésela'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END

--SELECT * FROM DEVOLUCIONES_VENTAS
-------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Modificar_Antes_P(
	
	@NUM_P INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(NOT EXISTS(SELECT * FROM PRODUCTO
	WHERE NUMERO_PRODUCTO = @NUM_P ))
		BEGIN
			SET @MSJ = 'El producto no existe, ingréselo'
			RETURN 1
		END
	ELSE
		RETURN 0

	
	END
-------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_FECHA_GARANTIA2(
	
	--@NUMERO_FACTURA INT,
	@FECHA_REALIZACION DATE,
	@FECHA_FACTURA DATE,
	--@NUMERO_PRODUCTO INT,
	@MSJ VARCHAR(200) OUT
							)
AS
	BEGIN
		--IF(EXISTS (SELECT 1 FROM ENCABEZADO_FACTURA INNER JOIN DETALLES_FACTURA  ON ENCABEZADO_FACTURA.NUMERO_FACTURA = DETALLES_FACTURA.NUMERO_FACTURA INNER JOIN
		--DEVOLUCIONES_VENTAS ON DETALLES_FACTURA.NUMERO_FACTURA = DEVOLUCIONES_VENTAS.NUMERO_FACTURA 
		--WHERE DETALLES_FACTURA.NUMERO_FACTURA = @NUMERO_FACTURA AND DETALLES_FACTURA.NUMERO_PRODUCTO = @NUMERO_PRODUCTO AND ENCABEZADO_FACTURA.FECHA =
		--@FECHA_FACTURA AND DEVOLUCIONES_VENTAS.FECHA_LIMITE_GARANTIA = @FECHA_FACTURA AND DEVOLUCIONES_VENTAS.FECHA_REALIZACION
		--= @FECHA_REALIZACION))
			BEGIN
				IF(DATEDIFF(DD,@FECHA_FACTURA,@FECHA_REALIZACION) > 30 )
					BEGIN
						SET @MSJ = 'La garantía de este producto ya expiró'
						RETURN 1
					END
			END
	 END
GO
	--DECLARE @RC int
	----DECLARE @NUMERO_FACTURA INT
	--DECLARE @FECHA_REALIZACION DATE
	--DECLARE @FECHA_FACTURA DATE
	----DECLARE @NUMERO_PRODUCTO INT
	--DECLARE @MSJ VARCHAR(100)

	----SET @NUMERO_FACTURA = 1
	--SET @FECHA_REALIZACION = '2022-09-22'
	--SET @FECHA_FACTURA = '2022-05-01'
	----SET @NUMERO_PRODUCTO = 3

	--EXECUTE @RC = [dbo].[VERIFICAR_FECHA_GARANTIA2]
	----@NUMERO_FACTURA,
	--@FECHA_REALIZACION,
	--@FECHA_FACTURA,
	----@NUMERO_PRODUCTO,
	--@MSJ OUTPUT
	--PRINT @MSJ

SELECT * FROM ENCABEZADO_FACTURA
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_Ingreso2(@NUMERO_PRODUCTO INT, 
											  --@NUMERO_FACTURA INT,
											  
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
			BEGIN
				IF(EXISTS(SELECT * FROM DEVOLUCIONES_VENTAS WHERE /*NUMERO_FACTURA=@NUMERO_FACTURA AND*/ NUMERO_PRODUCTO = @NUMERO_PRODUCTO))
				BEGIN
					SET @MSJ = 'Este producto ya se devolvió'
					RETURN 1
				END
			END
	END
GO
--DECLARE @RC int
--	--DECLARE @NUMERO_FACTURA INT
--	--DECLARE @NUMERO_FACTURA INT
--	DECLARE @NUMERO_PRODUCTO INT
--	--DECLARE @NUMERO_PRODUCTO INT
--	DECLARE @MSJ VARCHAR(100)

--	--SET @NUMERO_FACTURA = 1
--	--SET @NUMERO_FACTURA = 1551441331
--	SET @NUMERO_PRODUCTO = 6
--	--SET @NUMERO_PRODUCTO = 3

--	EXECUTE @RC = [dbo].[VERIFICAR_Ingreso2]
--	--@NUMERO_FACTURA,
--	--@NUMERO_FACTURA ,
--	@NUMERO_PRODUCTO ,
--	--@NUMERO_PRODUCTO,
--	@MSJ OUTPUT
--	PRINT @MSJ

SELECT * FROM DEVOLUCIONES_VENTAS
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_PRO(
	
	@NUM_PROVEEDOR INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM PROVEEDOR  
	WHERE NUM_PROVEEDOR = @NUM_PROVEEDOR ))
		BEGIN
			SET @MSJ = 'No puede insertar un número de proveedor que ya existe'
			RETURN 1
		END
	
END
/*---------------------------------------------------------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_PRODUCTO(
	
	@NUMERO_PRODUCTO INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM PRODUCTO  
	WHERE NUMERO_PRODUCTO = @NUMERO_PRODUCTO ))
		BEGIN
			SET @MSJ = 'No puede insertar un número de producto que ya existe'
			RETURN 1
		END
	
END
--/*------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_TRABAJADOR(
	
	@ID_TRABAJADOR INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM TRABAJADOR  
	WHERE ID_TRABAJADOR = @ID_TRABAJADOR ))
		BEGIN
			SET @MSJ = 'No puede insertar un ID de trabajador que ya existe'
			RETURN 1
		END
	
END
--/*------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_ODENES_COMPRA(
	
	@NUMERO_ORDEN INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM ORDENES_DE_COMPRA  
	WHERE NUMERO_ORDEN = @NUMERO_ORDEN ))
		BEGIN
			SET @MSJ = 'No puede insertar un número de orden de compra que ya existe'
			RETURN 1
		END
	
END
--/*------------------------------------------------------------------------------------------*/

--CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR_CLIENTE(
	
--	@ID_CLIENTE INT,
--	@MSJ VARCHAR(50) OUT )

	

--AS 
--	BEGIN
--	IF(EXISTS(SELECT * FROM CLIENTE 
--	WHERE ID_CLIENTE = @ID_CLIENTE ))
--		BEGIN
--			SET @MSJ = 'No puede insertar un ID de cliente que ya existe'
--			RETURN 1
--		END
	
--END
--/*------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR__ENC_F(
	
	@NUM_FACTURA  INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM ENCABEZADO_FACTURA
	WHERE NUMERO_FACTURA  = @NUM_FACTURA  ))
		BEGIN
			SET @MSJ = 'No puede insertar un número de factura que ya existe'
			RETURN 1
		END
	
END
--/*------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR__DETALLES_F(
	
	@NUM_FACTURA  INT,
  @NUM_PRODUCTO INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM DETALLES_FACTURA
	WHERE NUMERO_FACTURA   = @NUM_FACTURA AND NUMERO_PRODUCTO = @NUM_PRODUCTO  ))
		BEGIN
			SET @MSJ = 'No puede insertar un mismo numero da factura y producto en el mismo detalle, se borraran los datos automaticamente'
			--DELETE FROM DETALLES_FACTURA WHERE NUMERO_FACTURA = @NUMERO_FACTURA AND NUMERO_PRODUCTO = @NUMERO_PRODUCTO
			DELETE FROM ENCABEZADO_FACTURA WHERE NUMERO_FACTURA = @NUM_FACTURA
			RETURN 1
		END
	
END
--/*------------------------------------------------------------------------------------------*/

CREATE OR ALTER PROCEDURE VERIFICAR_ANTES_DE_INSERTSAR__DEVOLUCIONES_VENTAS(
	
	@NUMERO_DEVOLUCION INT,
	@MSJ VARCHAR(500) OUT )

	

AS 
	BEGIN
	IF(EXISTS(SELECT * FROM DEVOLUCIONES_VENTAS
	WHERE NUMERO_DEVOLUCION   = @NUMERO_DEVOLUCION   ))
		BEGIN
			SET @MSJ = 'No puede insertar un número de devoluciones de ventas que ya existe'
			RETURN 1
		END
	
END
/*------------------------------------------------------------------------------------------*/

--INSERTAR Y MODIFICAR UN PROVEEDOR
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICAR_PROV( @NUM_PROVEEDOR INT,
											  @NOMBRE_ORG VARCHAR(500),	
											  @CORREO VARCHAR(200),
										      @DIRECCION VARCHAR(900),
											  @TELEFONO VARCHAR(100),
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
				IF(EXISTS(SELECT * FROM PROVEEDOR WHERE NUM_PROVEEDOR = @NUM_PROVEEDOR AND NOMBRE_ORG = @NOMBRE_ORG AND CORREO = @CORREO AND DIRECCION = @DIRECCION AND 
				TELEFONO = @TELEFONO ))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	GO

--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UN PRODUCTO
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE Verificar_MODIFICAR_PRODUCTO( @NUMERO_PRODUCTO INT,
											  @NOMBRE_PRODUCTO VARCHAR(500),	
											  @TIPO_PRODUCTO VARCHAR(200),
										      @PRECIO_VENTA FLOAT,
											  @CANTIDAD INT,
											  @IMPUESTO FLOAT,
											  @DESCUENTO FLOAT,
											  @DESCRIPCION VARCHAR(500),
											  @GARANTIA VARCHAR(30),
											  @DISPONIBILIDAD VARCHAR(100),
											  @NUM_PROVEEDOR INT,
											  @PRECIO_COMPRA FLOAT,
											  @PRECIO_TOTAL FLOAT,
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
				IF(EXISTS(SELECT * FROM PRODUCTO WHERE NUMERO_PRODUCTO=@NUMERO_PRODUCTO AND NOMBRE_PRODUCTO=@NOMBRE_PRODUCTO  AND 
				TIPO_PRODUCTO=@TIPO_PRODUCTO AND PRECIO_VENTA=@PRECIO_VENTA AND CANTIDAD=@CANTIDAD AND IMPUESTO=@IMPUESTO AND 
				DESCUENTO=@DESCUENTO AND DESCRIPCION=@DESCRIPCION AND GARANTIA=@GARANTIA AND DISPONIBILIDAD=@DISPONIBILIDAD AND NUM_PROVEEDOR=@NUM_PROVEEDOR AND
				PRECIO_COMPRA = @PRECIO_COMPRA AND PRECIO_TOTAL = @PRECIO_TOTAL))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
				
			END
GO
SELECT * FROM PRODUCTO
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UN TRABAJADOR
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICAR_T( @ID_TRABAJADOR INT,
											  @NOMBRE VARCHAR(150),	
											  @APELLIDOS VARCHAR(200),
										      @TELEFONO VARCHAR(30),
											  @RESIDENCIA VARCHAR(300),
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
				IF(EXISTS(SELECT * FROM TRABAJADOR WHERE  ID_TRABAJADOR=@ID_TRABAJADOR AND NOMBRE=@NOMBRE AND APELLIDOS=@APELLIDOS AND 
				TELEFONO=@TELEFONO AND RESIDENCIA=@RESIDENCIA))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			
	END
GO
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UNA ORDEN DE COMPRA
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICACION_ORDEN( @NUMERO_ORDEN INT,
											  @NUMERO_PRODUCTO INT,	
											  @NUM_POVEEDOR INT,
										      @NOMBRE_PRODUCTO VARCHAR(200),
											  @FECHA_ORDEN_PEDIDO DATETIME,
											  @NUM_PROVEEDOR INT,
											  @PRECIO_X_UNIDAD FLOAT,
											  @IMPUESTO FLOAT,
											  @TOTAL_A_PAGAR FLOAT,
											  @CANTIDAD INT,
											  @ID_TRABAJADOR INT,
											  
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
	
			
				IF(EXISTS(SELECT * FROM ORDENES_DE_COMPRA WHERE NUMERO_ORDEN=@NUMERO_ORDEN AND NUMERO_PRODUCTO=@NUMERO_PRODUCTO AND NUM_PROVEEDOR=
				@NUM_POVEEDOR AND NOMBRE_PRODUCTO=@NOMBRE_PRODUCTO AND FECHA_ORDEN_PEDIDO=@FECHA_ORDEN_PEDIDO  AND NUM_PROVEEDOR = @NUM_PROVEEDOR AND PRECIO_X_UNIDAD=@PRECIO_X_UNIDAD AND IMPUESTO=@IMPUESTO AND TOTAL_A_PAGAR=@TOTAL_A_PAGAR AND ID_TRABAJADOR=
				@ID_TRABAJADOR AND CANTIDAD = @CANTIDAD))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
		
	END
GO

SELECT * FROM ORDENES_DE_COMPRA
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UN Cliente
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICACION_CLIENTE( @ID_CLIENTE INT,
											  @NOMBRE VARCHAR(150),	
											  @APELLIDOS VARCHAR(200),
										      @TELEFONO VARCHAR(30),
											  @RESIDENCIA VARCHAR(300),
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
			
				IF(EXISTS(SELECT * FROM CLIENTE WHERE ID_CLIENTE=@ID_CLIENTE AND NOMBRE=@NOMBRE AND APELLIDOS=@APELLIDOS AND TELEFONO=@TELEFONO AND
				RESIDENCIA=@RESIDENCIA))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	
GO
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UN ENCABEZADO DE FACTURA
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICACION_ENCAB( @NUMERO_FACTURA INT,
											  @ID_TRABAJADOR INT,
										      @IMPUESTO INT,
											  @MONTO_A_PAGAR FLOAT,
											  @ID_CLIENTE INT,
											  @MSJ VARCHAR(500) OUT)
AS
	
			BEGIN
				IF(EXISTS(SELECT * FROM ENCABEZADO_FACTURA WHERE NUMERO_FACTURA=@NUMERO_FACTURA AND ID_TRABAJADOR=@ID_TRABAJADOR  AND 
				IMPUESTO=@IMPUESTO AND MONTO_A_PAGAR=@MONTO_A_PAGAR AND ID_CLIENTE = @ID_CLIENTE))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	
GO

SELECT * FROM ENCABEZADO_FACTURA
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UN DETALLES DE FACTURA
--------------------------------------------------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------------------------------------------------
----INSERTAR Y MODIFICAR UNA DEVOLUCION DE VENTA
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIFICAR_MODIFICAR_DEVOLUCION_VENTA(@NUMERO_DEVOLUCION INT, 
											  @NUMERO_FACTURA INT,
											  @NUMERO_PRODUCTO INT,
											  @FECHA_REALIZACION DATE,	
											  @FECHA_DEVOLUCION DATE,
											  @MOTIVO_DEVOLUCION VARCHAR(500),
										      @ACEPTACION_DEVOLUCION VARCHAR(30),
											  @ID_TRABAJADOR INT,
											  @MSJ VARCHAR(500) OUT)
AS
	BEGIN
		
			BEGIN
				IF(EXISTS(SELECT * FROM DEVOLUCIONES_VENTAS WHERE NUMERO_DEVOLUCION= @NUMERO_DEVOLUCION AND NUMERO_FACTURA=@NUMERO_FACTURA AND
				NUMERO_PRODUCTO = @NUMERO_PRODUCTO AND  FECHA_REALIZACION=@FECHA_REALIZACION AND FECHA_LIMITE_GARANTIA=@FECHA_DEVOLUCION AND MOTVO_DEVOLUCION=@MOTIVO_DEVOLUCION AND ACEPTACION_DEVOLUCION=@ACEPTACION_DEVOLUCION AND
				ID_TRABAJADOR=@ID_TRABAJADOR ))
				BEGIN
					SET @MSJ = 'DEBE REALIZAR ALGUN CAMBIO PARA QUE SE ACTUALIZE'
					RETURN 1
				END
			END
	END
GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UN PROVEEDOR
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIF_ELIMINAR_PROVEEDOR(@NUM_PROVEEDOR INT,
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM PRODUCTO WHERE NUM_PROVEEDOR = @NUM_PROVEEDOR))
			
			BEGIN
			
				SET @MSJ = 'No se puede eliminar el proveedor'
				RETURN 1
			END

		ELSE IF(EXISTS(SELECT 1 FROM ORDENES_DE_COMPRA WHERE NUM_PROVEEDOR = @NUM_PROVEEDOR))
			BEGIN
				SET @MSJ = 'No se puede eliminar el proveedor'
				RETURN 1
			END
		ELSE
			BEGIN
			 RETURN 0
			END

	END
	
GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UN PRODUCTO
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE VERIF_ELIMINAR_PRODUCTO(@NUMERO_PRODUCTO INT,
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM ORDENES_DE_COMPRA WHERE NUMERO_PRODUCTO = @NUMERO_PRODUCTO))
			
			BEGIN
			
				SET @MSJ = 'No se puede eliminar el producto'
				RETURN 1
			END

		ELSE IF(EXISTS(SELECT 1 FROM DETALLES_FACTURA WHERE NUMERO_PRODUCTO = @NUMERO_PRODUCTO))
			BEGIN
				SET @MSJ = 'No se puede eliminar el producto'
				RETURN 1
			END
		ELSE IF(EXISTS(SELECT CANTIDAD FROM PRODUCTO WHERE NUMERO_PRODUCTO = @NUMERO_PRODUCTO AND CANTIDAD > 0 ))
			BEGIN
				SET @MSJ = 'No se puede eliminar el producto'
				RETURN 1			
					

			END
		ELSE
			BEGIN
			 RETURN 0
			END

	END
	
GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UNA ORDEN DE COMPRA
-------------------------------------------------------------------------------------------------------------------------------------------------
--CREATE OR ALTER PROCEDURE SP_ELIMINAR_ORDEN_COMPRA(@NUMERO_ORDEN INT,
--												@MSJ VARCHAR(200) OUT

--)
--AS
--BEGIN
--		If(EXISTS(SELECT 1 FROM ORDENES_DE_COMPRA WHERE NUMERO_ORDEN = @NUMERO_ORDEN))
			
--			BEGIN
--			DELETE FROM ORDENES_DE_COMPRA WHERE NUMERO_ORDEN = @NUMERO_ORDEN
--				SET @MSJ = 'Orden de compra borrada'
--				RETURN 1
--			END

--		ELSE
--			BEGIN
--				SET @MSJ = 'La orden de compra no existe'
--				RETURN 0
--			END

--	END
	
--GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UN TRABAJADOR
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE SP_ELIMINAR_TRABAJADOR(@ID_TRABAJADOR INT,
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM ENCABEZADO_FACTURA WHERE ID_TRABAJADOR = @ID_TRABAJADOR))
			
			BEGIN
			
				SET @MSJ = 'No se puede eliminar el trabajador'
				RETURN 1
			END

		ELSE IF(EXISTS(SELECT 1 FROM ORDENES_DE_COMPRA WHERE ID_TRABAJADOR = @ID_TRABAJADOR))
			BEGIN
				SET @MSJ = 'No se puede eliminar el trabajador'
				RETURN 1
			END
	    ELSE IF(EXISTS(SELECT 1 FROM DEVOLUCIONES_VENTAS WHERE ID_TRABAJADOR = @ID_TRABAJADOR))
			BEGIN
				SET @MSJ = 'No se puede eliminar el trabajador'
				RETURN 1
			END
		ELSE
			BEGIN
			 RETURN 0
			END

	END
	
GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UN CLIENTE
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE SP_ELIMINAR_CLIENTE(@ID_CLIENTE INT,
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM ENCABEZADO_FACTURA WHERE ID_CLIENTE = @ID_CLIENTE))
			
			BEGIN
			
				SET @MSJ = 'No se puede eliminar el cliente'
				RETURN 1
			END

		
		ELSE
			BEGIN
			 RETURN 0
			END

	END
	
GO
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UN ENCABEZADO DE FACTURA
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE SP_ELIMINAR_ENCABEZADO_FACTURA(@NUMERO_FACTURA INT,
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM DEVOLUCIONES_VENTAS WHERE NUMERO_FACTURA = @NUMERO_FACTURA))
			
			BEGIN
			
				SET @MSJ = 'No se puede eliminar la factura'
				RETURN 1
			END

		
		ELSE
			BEGIN
			 RETURN 0
			END

	END
	
GO


select * from ENCABEZADO_FACTURA
-------------------------------------------------------------------------------------------------------------------------------------------------
----ELIMINAR UNA DEVOLUCION DE VENTA
-------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR ALTER PROCEDURE V_ELIMINAR_DEVOLUCION_VENTA(@NUMERO_DEVOLUCION INT,
												@ACEPTACION_DEVOLUCION VARCHAR(100),
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT 1 FROM DEVOLUCIONES_VENTAS WHERE NUMERO_DEVOLUCION = @NUMERO_DEVOLUCION AND ACEPTACION_DEVOLUCION = @ACEPTACION_DEVOLUCION
		AND @ACEPTACION_DEVOLUCION = 'Si' ))
			BEGIN
				SET @MSJ = 'No se puede eliminar la deevolucion'
				RETURN 1
			END
	    ELSE
			BEGIN
			 RETURN 0
			END
	

	END
	
GO

--TRIGGERS
CREATE OR ALTER TRIGGER TR_VENTA
ON DETALLES_FACTURA
FOR INSERT
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD INT

SELECT @CANTIDAD=CANTIDAD_COMPRADA FROM inserted
SELECT @ID_PRIMARY_KEY=NUMERO_PRODUCTO FROM inserted


 UPDATE PRODUCTO
 SET CANTIDAD=CANTIDAD-@CANTIDAD
 WHERE NUMERO_PRODUCTO=@ID_PRIMARY_KEY

 GO
 -----------------------
 CREATE OR ALTER TRIGGER TR_VENTA2
ON ORDENES_DE_COMPRA
FOR INSERT
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD INT

SELECT @CANTIDAD=Cantidad FROM inserted
SELECT @ID_PRIMARY_KEY=NUMERO_PRODUCTO FROM inserted


 UPDATE Producto
 SET Cantidad=Cantidad+@CANTIDAD
 WHERE NUMERO_PRODUCTO=@ID_PRIMARY_KEY

 GO

 ----------------------------------------
  CREATE OR ALTER TRIGGER TR_VENTA5
ON ORDENES_DE_COMPRA
FOR UPDATE
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD INT

SELECT @CANTIDAD=Cantidad FROM inserted
SELECT @ID_PRIMARY_KEY=NUMERO_PRODUCTO FROM inserted


 UPDATE Producto
 SET Cantidad=Cantidad+@CANTIDAD
 WHERE NUMERO_PRODUCTO=@ID_PRIMARY_KEY

 GO
 -----------------------------------------------------------
  CREATE OR ALTER TRIGGER TR_VENTA3
ON ORDENES_DE_COMPRA
FOR DELETE
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD INT

SELECT @CANTIDAD=Cantidad FROM deleted
SELECT @ID_PRIMARY_KEY=NUMERO_PRODUCTO FROM deleted


 UPDATE Producto
 SET Cantidad=Cantidad-@CANTIDAD
 WHERE NUMERO_PRODUCTO=@ID_PRIMARY_KEY

 GO
 -------------------------------------
 CREATE OR ALTER TRIGGER TR_VENTA4
ON DETALLES_FACTURA
FOR DELETE
AS
DECLARE @ID_PRIMARY_KEY VARCHAR(30)
DECLARE @CANTIDAD INT

SELECT @CANTIDAD=CANTIDAD_COMPRADA FROM deleted
SELECT @ID_PRIMARY_KEY=NUMERO_PRODUCTO FROM deleted


 UPDATE PRODUCTO
 SET CANTIDAD=CANTIDAD+@CANTIDAD
 WHERE NUMERO_PRODUCTO=@ID_PRIMARY_KEY

 GO

 ---------------------------------------------------------------------------------------------------------------------------------------------
 CREATE OR ALTER PROCEDURE VERIFICAR_D(@NUMERO_DEVOLUCION INT,
										@NUMERO_PRODUCTO INT,
												@ACEPTACION_DEVOLUCION VARCHAR(100),
												@MSJ VARCHAR(200) OUT

)
AS
BEGIN
		If(EXISTS(SELECT * FROM DEVOLUCIONES_VENTAS INNER JOIN DETALLES_FACTURA ON DEVOLUCIONES_VENTAS.NUMERO_FACTURA = 
		DETALLES_FACTURA.NUMERO_FACTURA AND DEVOLUCIONES_VENTAS.NUMERO_PRODUCTO = DETALLES_FACTURA.NUMERO_PRODUCTO WHERE 
		DETALLES_FACTURA.GARANTIA = 'No Aplica'))
			BEGIN
				SET @MSJ = 'Este producto no tiene garantía'
				RETURN 1
			END
	    ELSE
			BEGIN
			 RETURN 0
			END
	

	END
	
GO

SELECT * FROM DETALLES_FACTURA
SELECT * FROM ENCABEZADO_FACTURA
