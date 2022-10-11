package utils;

public interface IConstants {
    //Constantes a ser utilizadas en el simulador para los threads que implementan Runnable & IConstants
    public static final int DIAS_ANIOS = 365;
    public static final int DIAS_MILIS = 2000;
    public static final int CHECK = DIAS_MILIS;

    public static final String ACTUALIZAR_DIAS = "DIAS";
    public static final String ACTUALIZAR_CLIMA = "CLIMA";

    public static final int THREAD_POOL_SIZE = 5;//
}
