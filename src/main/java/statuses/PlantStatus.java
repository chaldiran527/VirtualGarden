package statuses;

public enum PlantStatus {
    ALMACIGO(0),MEDIANA(1),GRANDE(2),MUERTA(3);
    private final int ID;

    PlantStatus(int id){
        this.ID = id;
    }

    public int getID(){
        return ID;
    }

}
