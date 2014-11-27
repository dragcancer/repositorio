package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.DiaLaborado;

public interface DAODiaLaborado {
	public boolean agregaDiaLaborado(DiaLaborado diaLaborado);
	public DiaLaborado[] dameDiasLaborados(String idUsuario, String fecha, String fechaLimite);
	public DiaLaborado buscaUsuario(String id);
	public DiaLaborado buscaId(String id,String fecha);
	public boolean actualizaHoraSalida(String id,String fecha,String horasal);
}
