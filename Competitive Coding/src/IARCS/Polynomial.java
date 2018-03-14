package IARCS;



public class Polynomial {
	 int max_degree=0;
		int coeff[] = new int[1];
		 
		/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
		 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
		 *  is already present in the polynomial then previous coefficient is replaced by
		 *  new coefficient value passed as function argument
		*/
		

		
//		public void setCoefficient(int degree, int coeff){
//		    
//		    if(degree>max_degree){
//		        max_degree=degree;
//		    }
//		    
//		    if(this.max_degree==this.coeff.length)
//		    this.coeff=resize(this.coeff.length);
//	      /*   int count=0;
//	        count++;
//	       if(count==degree.length){
//	           increase_size(coeff.length);
//	       }*/
//	      
//	      this.coeff[degree]=coeff;
//			
//		}
		
		public void setCoefficient(int degree, int coeff){
	        if(degree >= this.coeff.length){
	            restructure();
	        }else{
	            this.coeff[degree] = coeff;
	        }       
		}
		
		public void restructure(){
		    int temp[] = coeff;
		    coeff = new int[coeff.length*2];
		    for(int i = 0; i < temp.length; i++){
		        coeff[i] = temp[i];
		    }
		}


		
		// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
		public void print(){
			
			for(int i=0;i<=max_degree;i++){
			    if((this.coeff[i])!=0){
			    System.out.print(this.coeff[i]+"x"+i+" ");
			}
		}
	}
		
		private int[] resize(int n){
		    
		    int[] temp=coeff;
		    int[] coeff = new int[(2*n)+1];
		    for(int i=0;i<temp.length;i++){
		        coeff[i]=temp[i];
		    }
		    return coeff;
		}
	/*	public  void increase_size(int n){
		    
		    int[] temp=coeff;
		   
		    int[] coeff  = new int[2*n+1];
		    
		    
		}*/

		
		// Adds two polynomials and returns a new polynomial which has result
		public Polynomial  add(Polynomial p){
	          int length;
	          if(this.max_degree>p.max_degree)
	          length=this.max_degree;
	          else
	          length=p.max_degree;
			Polynomial poly = new Polynomial();
			
			for(int i=0;i<=length;i++){
			    poly.coeff[i]=this.coeff[i]+p.coeff[i];
			}
			poly.max_degree=length;
			return poly;
		}
		
		// Subtracts two polynomials and returns a new polynomial which has result
		public Polynomial  subtract(Polynomial p){
	          int length;
	          if(this.max_degree>p.max_degree)
	          length=this.max_degree;
	          else
	          length=p.max_degree;
			Polynomial poly = new Polynomial();
			
			for(int i=0;i<=length;i++){
			    poly.coeff[i]=this.coeff[i]-p.coeff[i];
			}
			poly.max_degree=length;
			return poly;
				
		}
		
		// Multiply two polynomials and returns a new polynomial which has result
		public Polynomial multiply(Polynomial p){
		    
		    Polynomial poly = new Polynomial();
		   
		    int i=0,j=0;
		    for( i=0;i<=this.max_degree;i++){
		        for( j=0;j<=p.max_degree;j++){
		            if(this.coeff[i]!=0 && p.coeff[j]!=0){
		            poly.coeff[i+j]=(this.coeff[i])*(p.coeff[j]);
		        }
		    }
		    }
		    poly.max_degree=i+j;
		    return poly;
			
		}

}

/*public class Polynomial {
    private int data[];
    
    //constructor
    
    public Polynomial(){
        data = new int[10];
    }
	
	 This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	
	public void setCoefficient(int degree, int coeff){
	    int a = degree;
	    int b = coeff;
        if(a >= data.length){
            restructure(a, b);
        }else{
            data[a] = b;
        }       
	}
	
	public void restructure(int a, int b){
	    int temp[] = data;
	    data = new int[data.length*2];
	    for(int i = 0; i < temp.length; i++){
	        data[i] = temp[i];
	    }
	    setCoefficient(a , b);
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i = 0; i < data.length; i++){
		    if(data[i] != 0){
		        System.out.print(data[i]+"x"+i+" ");
		    }//end of if
		}//end of for loop
	}

	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
        
       
        int i = 0;
		int[] result = new int[Math.max(this.data.length , p.data.length)];
		
		for(i = 0; i < Math.min(this.data.length , p.data.length);i++){
		    result[i] = p.data[i] + this.data[i];
		}
		
		if(i == this.data.length){
		    while(i < p.data.length){
		        result[i] = p.data[i];
		        i++;
		    }//end of while loop
		}else{
		    while(i < this.data.length){
		        result[i] = this.data[i];
		        i++;
		    }//end of while loop
		}//end of if loop
		
			Polynomial obj = new Polynomial();
		for(i = 0; i < result.length; i++){
		    if(result[i] != 0){
			obj.setCoefficient(i,result[i]);
		    }
		}
		
		return obj;
		
		
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
			 
			 
			 int i = 0;
		
		int[] result = new int[Math.max(this.data.length , p.data.length)];
		
		for(i = 0; i < Math.min(this.data.length , p.data.length);i++){
		    if(p.data[i] > this.data[i]){
		        result[i] = p.data[i] - this.data[i];
		    }else{
		        result[i] =this.data[i] - p.data[i];
		    }
		}
		
		if(i == this.data.length){
		    while(i < p.data.length){
		        result[i] = p.data[i];
		        i++;
		    }//end of while loop
		}else{
		    while(i < this.data.length){
		        result[i] = this.data[i];
		        i++;
		    }//end of while loop
		}//end of if loop
		
		Polynomial obj = new Polynomial();
		for( i = 0; i < result.length; i++){
		    if(result[i] != 0){
			obj.setCoefficient(i,result[i]);
		    }
		}
		
		return obj;
		
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		int i = 0;
	     
		
		int[] result = new int[this.data.length * p.data.length];
		for(i = 0; i < this.data.length; i++){
		    if(this.data[i] != 0){
		    for(int j = 0; j < p.data.length; j++){
		     if(p.data[j] != 0 ){
		        if(result[i + j] == 0){
		            result[i + j] = p.data[j] * this.data[i];
		        }else{
		            int temp = result[i + j];
		            result[i + j] = ( p.data[j] * this.data[i] )+ temp;
		        }
		     }//end of if statement 
		    }//end of second for loop
		    }//end of if
		}//end of first for loop
		Polynomial obj = new Polynomial();
		for(i = 0; i < result.length; i++){
		    if(result[i] != 0){
			obj.setCoefficient(i,result[i]);
		    }
		}
		
		return obj;
		
	}

}*/