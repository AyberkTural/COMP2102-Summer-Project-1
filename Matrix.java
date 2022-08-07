public class Matrix  {
    
   MatrixNode initial;
    
   MatrixNode end;
 
   int N = 0;
    
   int D;     
    
   int arrive = 1;
    
   private Navigator navigator;
   
   public Matrix(int D) {
        
        initial = null;
        
        end = null;
      
        N = 0;
        
        this.D = D;
        
        construction();
        
        System.out.println("");
       
        adjustment();
        
        System.out.println(""); 
        
    }
    
    public boolean isEmpty(){
        
        return N == 0;
        
    }
    
    private void putCell(MatrixNode newNode){
       
        if(isEmpty()){
           
            initial = newNode;
            
            end = newNode;
            
            N++;
           
            return;
        }
        
        else {
           
            end.E =newNode;
            
        }
        
        newNode.W = end;
       
        end = newNode;
       
       N++;
        
    }
    
   private void construction() {
      
        MatrixNode newNode = null; 
        
        int count = 0;
         
        for (int i = 0 ;  i < D ; i++) {
            
            for (int j = 0 ; j < D ; j++) {
                
                newNode = new MatrixNode("○");   
                
                newNode.index = count;
                
                newNode.columnindex = j;
              
                putCell(newNode);
                
                count++;
                
            }
    }
 
    }
  
   private void adjustment() {
        
       MatrixNode constant = initial;
        
       MatrixNode temp = initial;
        
       int count = 0;
        
        for (int i = 0 ; i < D; i++) {
            
            for (int j = 0 ; j <= 2*D - 2; j++) {
             
            count++;
             
             if (((constant.index)+D)==temp.index){
                 
              constant.S = temp;  
              
              temp.N = constant;
              
              constant = constant.E;   
               
             }
          
             else {
                   
                 temp = temp.E;
                   
             }
  
            }
            
        }
   
    }
   
   private boolean check (MatrixNode voyager) {       
       
       int value = voyager.arrived;
       
       if (value==1){
           
           arrive++;
           
       }
       
       return N == arrive;
              
   }

     void voyage () {    
       
       Navigator navigator = new Navigator (this);  
       
       MatrixNode voyager = navigator.whereAreYou();
     
       voyager.arrived = 1;
      
       int counter = 0;
      
       System.out.println("Position is : "+voyager.index);
      
       System.out.println("");
      
       MatrixNode temp = voyager;
       
       print();
       
       System.out.println("");
       
       boolean journey = true;
     
       System.out.println("");
       
        
       
      while (journey) {
  
          int direction = (int) (Math.random()*4); 
          
          switch (direction) {
              
              case 0 :
                  
                  temp.signal = "○";
                  
                  temp = navigator.N(temp);
                  
                  temp.signal = "●";
                                   
                  temp.arrived = temp.arrived + 1 ;
                  
                  print();
                  
                  System.out.println("");
                  
                  System.out.println("Position is : "+temp.index);
                  
                  System.out.println("");
                  
                  break;
                  
              case 1 :
                  
                  temp.signal = "○";
                  
                  temp = navigator.S(temp);
                  
                  temp.signal = "●";
                  
                  temp.arrived = temp.arrived + 1 ;
                  
                  System.out.println("");
                    
                  print();
                 
                  System.out.println("Position is : "+temp.index);
                  
                  System.out.println("");
                  
                  break;
              
              case 2 :
                  
                  temp.signal = "○";
                  
                  temp = navigator.E(temp);
                  
                  temp.signal = "●";
                  
                  temp.arrived = temp.arrived + 1 ;
                  
                  System.out.println("");
                  
                  print();
                  
                  System.out.println("Cell is : "+temp.index);
                  
                  System.out.println("");
                  
                  break; 
                  
              case 3 :
                  
                  temp.signal = "○";
                  
                  temp = navigator.W(temp);
                  
                  temp.signal = "●";
                  
                  temp.arrived = temp.arrived + 1;  
                  
                  System.out.println("");
                  
                  print();
                  
                  System.out.println("Position is : "+temp.index);
                  
                  System.out.println("");
                  
                  break; 
            
          }
          
          System.out.println("");
          
          if (check(temp)) {
              
          journey = false;   
              
          }
                     
          }
         
        }
    
 void AVLImplementation() {
      
        AVLTree avltree = new AVLTree ();
        
        MatrixNode temp = initial;
         
        for (int i = 0 ;  i < D ; i++) {
            
            for (int j = 0 ; j < D ; j++) {
                
                avltree.insert(temp, temp.arrived);
                
                System.out.println("Arrived is : "+temp.arrived);
          
                temp = temp.E;
                
            }

            System.out.println("");
            
        }
        
        System.out.println("Pre Order : ");
        
        avltree.preOrder(avltree.root);
        
       System.out.println("");
        
        System.out.println("In Order : ");
        
        avltree.inOrder(avltree.root);
        
       System.out.println("");
        
        System.out.println("Post Order : ");
        
        avltree.postOrder(avltree.root);
        
      }
        
   private void print(){
       
        MatrixNode temp = initial;
         
        for (int i = 0 ;  i < D ; i++) {
            
            for (int j = 0 ; j < D ; j++) {
                
                System.out.print(temp.signal+" ");
                
                temp = temp.E;
         
            }

            System.out.println("");
            
        }
    
      }
   
 }
