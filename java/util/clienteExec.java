package util;

public enum clienteExec {
	
	CLIENTE{
		public cliente obterCliente(){
			return new cliente(
					"54545454",
					"54545454"
					);
		}
	},

	CLIENTE2{
		public cliente obterCliente(){
			return new cliente(
				"54545454",
				"54545454"
				);
		}
	};

	public abstract cliente obterCliente(); 

};
