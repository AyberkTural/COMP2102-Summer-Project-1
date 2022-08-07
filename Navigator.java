
 public class Navigator {
    
    Matrix matrix;
    
    
    public Navigator(Matrix matrix) {
        
        this.matrix = matrix;
        
    }
    
    MatrixNode whereAreYou() { 
    
        int spawnx = (int)(Math.random()*(matrix.D));
  
        int spawny = (int)(Math.random()*(matrix.D));
        
        MatrixNode temp = matrix.initial;    
        
        MatrixNode location = null;
         
        for (int i = 0 ;  i < matrix.D ; i++) {
            
            for (int j = 0 ; j < matrix.D ; j++) {                

                if ((temp.rowindex == spawnx)&&(temp.columnindex == spawny)) {
                    
                    location = temp;
                    
                    location.signal = "■";
                    
                    break;
                    
                  } else {
                    
                     temp = temp.E;     
                    
                }
                
            }
            
        }
       
       return location;
       
   }  
    
     MatrixNode N (MatrixNode voyager) {
       
      MatrixNode temp = voyager; 
       
      int again = (int) (Math.random()*3);
      
      if (temp.N!=null&&(temp.rowindex!=(0))){
          
          System.out.println("Going to the north.");
          
          temp = temp.N;
          
          System.out.println("");
          
      }
      
      else {
          
          switch (again) {
              
              case 0 : 
                  
                temp = S(temp);
                  
                  break;
              
              case 1 :
              
               temp = W(temp); 
              
                  break;
                  
              case 2 : 
                  
               temp =  E(temp); 
               
                  break;
                  
          }
      
      }
  
       return temp;
       
   }
   
     MatrixNode S (MatrixNode voyager) {
       
      MatrixNode temp = voyager; 
       
      int again = (int) (Math.random()*3);
      
      if (temp.S!=null&&(temp.rowindex!=(matrix.D-1))){
          
          System.out.println("Going to the south.");
          
          temp = temp.S;
          
          System.out.println("");
          
      }
      
      else {
          
            switch (again) {
              
              case 0 : 
                  
                temp = N(temp);
                  
                  break;
              
              case 1 :
              
               temp = E(temp); 
              
                  break;
                  
              case 2 : 
                  
               temp = W(temp); 
              
                  break;
              
          }
       
      }
   
       return temp;
       
   }
    
     MatrixNode E (MatrixNode voyager) {
       
      MatrixNode temp = voyager; 
       
      int again = (int) (Math.random()*3);
      
      if ((temp.E!=null)&&(temp.columnindex!=(matrix.D-1))){
          
          System.out.println("Going to the east.");
          
          temp = temp.E;
          
          System.out.println("");
          
      }
      
      else {
          
          switch (again) {
              
              case 0 : 
                  
                temp = N(temp);
                  
                  break;
              
              case 1 :
              
               temp = S(temp); 
              
                  break;
                  
              case 2 : 
                  
               temp = W(temp); 
              
                  break;
               
               
          }
          
      }
    
       return temp;
       
   }
    
    MatrixNode W (MatrixNode voyager) {
       
      MatrixNode temp = voyager; 
       
      int again = (int) (Math.random()*3);
      
      if ((temp.W!=null)&&((temp.columnindex)!=0)){
          
          System.out.println("Going to the west.");
          
          temp = temp.W;
          
          System.out.println("");
          
      }
      
      else {
          
           switch (again) {
              
              case 0 : 
                  
                temp = N(temp);
                  
                  break;
              
              case 1 :
              
               temp = S(temp); 
              
                  break;
                  
              case 2 : 
                  
               temp = E(temp); 
              
                  break;
      
          }
    
      }
 
       return temp;
       
   }
    
 
}
