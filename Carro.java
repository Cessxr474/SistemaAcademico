class Carro {
    String marca;
    String color;
    int Velocidad;

    public Carro (String marca, String color){
        this.marca = marca;
        this.color = color;
        this.Velocidad = 0;
    }

    public void acelerar (){
        Velocidad += 10;
        System.out.println("La velocidad del auto es " + Velocidad + " km/h");

    }
        public void frenar (){
            Velocidad -= 10;
            if (Velocidad < 0){
                Velocidad = 0;
            }
            System.out.println("La velocidad del auto es " + Velocidad + " km/h");
        }
 
}