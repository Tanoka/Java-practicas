package basic;

enum Estado {
	activo, desactivado, pendiente, noquiere
}

//Java enumeration is a class type.
enum Fruta {
	Manzana("verde"), Pera("amarillo"), Melocoton("Marron"), Platano("Amarillo");

	private String color;

	Fruta(String col) {
		color = col;
	}

	String getColor() {
		return color;
	}

}

class Enumerations {
	public static void main(String[] args) {

		Estado questd;
		questd = Estado.activo;


		if (questd == Estado.desactivado) {
			System.out.println("desactivado");
		} else if (questd == Estado.activo) {
			System.out.println("activo");
	        } 


		switch (questd) {
			case desactivado:
			System.out.println("desactivado from case");
			break;
			case activo:
			System.out.println("activo from case");
			break;
		}


		// All enumerations automatically contain predefined methods: values( ) valueOf( )
		// ordinal() compareTo() equals() 
		
		System.out.println("Estado valueOf"+Estado.valueOf("pendiente"));

		for (Estado std : Estado.values()) {
			System.out.println("Estado"+std + " posicion " + std.ordinal());
		}


		System.out.println(Fruta.Manzana.getColor());

                for (Fruta frt : Fruta.values()) {
                        System.out.println(frt + ": "+ frt.getColor());
                }  



	}

}
