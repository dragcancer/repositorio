package ayd.managment.store.persistencia.clase;
import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {


/*	public static void main(String[] args){
		try{
			Connection connection = ManejadorBD.dameConnection();

			Statement statement = connection.createStatement();
	*/	
			/*
			para correr por primera vez comentar las siguientes 5 lineas...
			statement.execute("drop table DiaLaborado");
			statement.execute("drop table Historial");
			statement.execute("drop table Producto");
			statement.execute("drop table Venta");
		 	statement.execute("drop table Usuario");
		 	System.out.println("tablas borradas");
			
			
		 	statement.execute("create table Usuario(usuarioId VARCHAR(6) PRIMARY KEY not null, nombre VARCHAR(128) not null, apellidoPaterno VARCHAR(128) not null, apellidoMaterno VARCHAR(128) not null, calle VARCHAR(128) not null, numeroExterior INTEGER not null, numeroInterior INTEGER, colonia VARCHAR(128), municipio VARCHAR(128) not null, codigoPostal INTEGER not null, telefono VARCHAR(10) not null, tipoUsuario INTEGER not null, password VARCHAR(20) not null)");
			System.out.println("tabla Usuario creada");
			
			
			statement.execute("create table Producto(codigo VARCHAR(15) PRIMARY KEY not null, nombre VARCHAR(128) not null, precioCompra FLOAT not null, precioMenudeo FLOAT not null, precioMayoreo FLOAT not null, cantidadMayoreo FLOAT not null, proveedor varchar(128) not null, existenciaActual FLOAT not null, existenciaMinima FLOAT not null, existenciaMaxima FLOAT not null, tipo INTEGER not null,FOREIGN KEY (proveedor) REFERENCES Proveedor(proveedor))");
		 	System.out.println("tabla Producto creada");
		 	
			
		 	statement.execute("create table Venta(ventaId INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), fecha DATE not null, hora TIME not null, ganancia FLOAT not null)");
			System.out.println("tabla Venta creada");
			
			statement.execute("create table Historial(fecha DATE PRIMARY KEY not null, cantidad INTEGER not null, total FLOAT not null)");
			System.out.println("tabla Historial creada");
			
		 	statement.execute("create table DiaLaborado(Id INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),fecha DATE, HoraEntrada TIME not null, HoraSalida TIME, usuarioId VARCHAR(6), FOREIGN KEY (usuarioId) REFERENCES Usuario(usuarioId))");
			System.out.println("tabla Hora creada");
			
			statement.execute("create table Proveedor(proveedor varchar(128) PRIMARY KEY not null, telefono VARCHAR(10) not null, tipo VARCHAR(25))");
			System.out.println("tabla Hora creada");
			
			
			statement.execute("insert into Usuario values ('ldg752','luz','dominguez','guido','2 poniente',111, null, null,'iztapalapa',11111,'2210216752',1,'210216752')");
			statement.execute("insert into Usuario values ('agc849','alfredo','garcia','colin','2 poniente',222, null, null,'iztapalapa',22222,'2209340849',1,'209340849')");
			statement.execute("insert into Usuario values ('mpm993','mauricio','perez','martinez','2 poniente',333, null, null,'iztapalapa',33333,'2210342993',1,'210342993')");
			statement.execute("insert into Usuario values ('rpz383','roman','perez','zarazua','2 poniente',444, null, null,'iztapalapa',44444,'2210332383',1,'210332383')");
			statement.execute("insert into Usuario values ('mra087','mariano','rodriguez','arias','2 poniente',555, null, null,'iztapalapa',55555,'2133012087',1,'2133012087')");
			statement.execute("insert into Usuario values ('cvc476','cesar','villalba','cortes','2 poniente',666, null, null,'iztapalapa',66666,'2210341476',1,'210341476')");
			statement.execute("insert into Usuario values ('mpm994','mauricio','perez','martinez','2 poniente',333, null, null,'iztapalapa',33333,'2210342993',0,'210342993')");
		 	System.out.println("Usuarios agregados");
		 	
		 	
		 	statement.execute("insert into Producto values ('1112','leche lala 1 litro',20,24,22,4,'lala',10,2,15,1)");
			statement.execute("insert into Producto values ('1113','coca cola 600 ml',10,12,11,6,'coca cola',40,10,100,1)");
			statement.execute("insert into Producto values ('1114','coca cola 2 litros',20,24,22,12,'coca cola',40,10,100,1)");
			statement.execute("insert into Producto values ('1115','coca cola 3 litros',30,36,33,20,'coca cola',40,10,100,1)");
			statement.execute("insert into Producto values ('1116','azucar',10,12,11,50,'casa suarez',75,50,300,0)");
			statement.execute("insert into Producto values ('1117','harina',15,18,16.5,45,'casa suarez',30,50,200,0)");
			
			
			statement.execute("insert into DiaLaborado values(DEFAULT,'2014-07-07','08:40:00','22:40:00','mpm993')");
			statement.execute("insert into DiaLaborado values(DEFAULT,'2014-07-08','08:40:00','21:40:00','mpm993')");
		 	statement.execute("insert into DiaLaborado values(DEFAULT,'2014-07-09','08:40:00','20:40:00','mpm993')");
		 	statement.execute("insert into DiaLaborado values(DEFAULT,'2014-07-10','08:40:00','20:40:00','mpm993')");
*/
		 	
			/*statement.execute("insert into Proveedor values('pepsi','2154789644','refrescos')");
			 
			statement.execute("insert into Proveedor values('pepsi-hg','21547444','refresm')");
			statement.execute("insert into Proveedor values('gomichelas-cerv','21547444','refresm')");*/
		//	statement.execute("insert into Proveedor values('coca-cola','2154744411','refrescos')");
	//		statement.execute("insert into Proveedor values('Bimbo','2154344422','pan')");
		//	statement.execute("insert into Proveedor values('Marinela','2254743411','galletas')");
	/*		statement.execute("insert into Venta values(DEFAULT,'2014-01-01','08:40:00',3.0)");
			statement.execute("insert into Venta values(DEFAULT,'2014-01-02','08:40:00',9.0)");
			statement.execute("insert into Venta values(DEFAULT,'2014-01-03','08:40:00',10.0)");
			statement.execute("insert into Venta values(DEFAULT,'2014-02-02','08:40:00',12.0)");
		*/	
			
/*		statement.execute("create table Gasto(Id INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), usuarioId VARCHAR(6) not null,fecha DATE not null, descripcion VARCHAR(30) not null, abono FLOAT not null)");
			statement.execute("create table Gasto(Id INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  , usuarioId VARCHAR(6) not null, gasto VARCHAR(15) not null ,fecha DATE not null, descripcion VARCHAR(30) not null, abono FLOAT not null,FOREIGN KEY (usuarioId) REFERENCES Usuario(usuarioId))");
			
			System.out.println("tabla Hora creada");
			statement.execute("drop table Gasto");
			System.out.println("Productos agregados");
	*/	 	
	/*	 	ManejadorBD.termina();
		 	
		 	
	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
}
