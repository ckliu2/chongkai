< % @   i n c l u d e   f i l e = " / c o m m o n / w e b t a g . j s p " % >  
  
 < h t m l >  
   < h e a d >  
 	  
 < l i n k   r e l = " s t y l e s h e e t "   t y p e = " t e x t / c s s "   h r e f = " $ { c t x } / c s s / s t y l e . c s s "   / >  
 < l i n k   r e l = " s t y l e s h e e t "   t y p e = " t e x t / c s s "   h r e f = " $ { c t x } / c s s / d i s p l a y t a g . c s s "   / >            
  
 < ! - - - e a s y u i - - >  
 < s c r i p t   s r c = " $ { c t x } / s c r i p t s / j q u e r y - 1 . 7 . 2 . j s " > < / s c r i p t >      
 < l i n k   r e l = " s t y l e s h e e t "   t y p e = " t e x t / c s s "   h r e f = " $ { c t x } / c s s / e a s y u i . c s s " >  
 < l i n k   r e l = " s t y l e s h e e t "   t y p e = " t e x t / c s s "   h r e f = " $ { c t x } / c s s / i c o n . c s s " >  
  
 < s c r i p t   t y p e = " t e x t / j a v a s c r i p t "   s r c = " $ { c t x } / s c r i p t s / j q u e r y . e a s y u i . m i n . j s " > < / s c r i p t >  
 < s c r i p t   t y p e = " t e x t / j a v a s c r i p t "   s r c = " $ { c t x } / s c r i p t s / b u l l e t i n . j s "   i d = " b u l l e t i n "   m e m b e r I d = " $ { l o g i n U s e r . i d } "     c h a r s e t = " b i g 5 " > < / s c r i p t >    
  
  
 < / h e a d >  
  
 < b o d y >  
 	  
 < t a b l e   b o r d e r = " 0 "   c e l l s p a c i n g = " 1 "   >  
             < t r >  
                 < t d   c l a s s = " c C o n t e n t T i t l e " > $ { l o g i n U s e r . c n a m e }   �`}Y�ˊ4���1XTNR���f��z< / t d >  
             < / t r >  
              
          
             < t r   c l a s s = " c A c t i o n B u t t o n L i n e " >  
                 < t d >  
                  
                 < / t d >  
             < / t r >  
             < t r >  
                 < t d >  
 < w w : s e t   n a m e = " c o u r s e "   v a l u e = " % { g e t C o u r s e L i s t ( ) } " / >  
 	                 	  
 < d i s p l a y : t a b l e   n a m e = " c o u r s e "   c l a s s = " l i s t "   c e l l s p a c i n g = " 1 "   r e q u e s t U R I = " "   i d = " r o w "   e x p o r t = " f a l s e "   p a g e s i z e = " $ { G L O B A L _ p a g e s i z e } "   s o r t = " l i s t " >  
         < d i s p l a y : s e t P r o p e r t y   n a m e = " p a g i n g . b a n n e r . p l a c e m e n t "   v a l u e = " b o t t o m "   / >  
         < d i s p l a y : c o l u m n   p r o p e r t y = " n o "   s o r t a b l e = " t r u e "   t i t l e K e y = " c o u r s e . n o "   s t y l e = " t e x t - a l i g n : l e f t "   / >  
         < d i s p l a y : c o l u m n   p r o p e r t y = " c o u r s e N a m e "   s o r t a b l e = " t r u e "   t i t l e K e y = " c o u r s e . c o u r s e N a m e "   s t y l e = " t e x t - a l i g n : l e f t "   / >  
         < d i s p l a y : c o l u m n   p r o p e r t y = " t i m e s "   s o r t a b l e = " t r u e "   t i t l e K e y = " c o u r s e . t i m e s "   s t y l e = " t e x t - a l i g n : l e f t "   / >  
          
         < d i s p l a y : c o l u m n   t i t l e = " ��z��f"   s t y l e = " t e x t - a l i g n : c e n t e r " >       	  
         	  
         	   < i m g   s r c = " $ { c t x } / i m a g e s / v i e w . g i f "   o n C l i c k = " $ ( ' # w $ { r o w _ r o w N u m } ' ) . w i n d o w ( ' o p e n ' ) "   / >  
         	    
         	   < d i v   i d = " w $ { r o w _ r o w N u m } "   c l a s s = " e a s y u i - w i n d o w "   t i t l e = " $ { r o w . c o u r s e N a m e } ��z��f"   d a t a - o p t i o n s = " m o d a l : t r u e , c l o s e d : t r u e , i c o n C l s : ' i c o n - s a v e ' "   s t y l e = " w i d t h : 6 0 0 p x ; h e i g h t : 4 0 0 p x ; p a d d i n g : 1 0 p x ; " >  
                   $ { r o w . d e s c r i p t i o n }  
               < / d i v >    
                
         < / d i s p l a y : c o l u m n > 	  
          
          
         < d i s p l a y : c o l u m n   t i t l e = " 1XTǌ
�"   s t y l e = " t e x t - a l i g n : c e n t e r " >         	  
         	 < w w : s e t   n a m e = " c o u r s e m e m b e r "   v a l u e = " % { g e t C o u r s e M e m b e r ( $ { r o w . i d } ) } " / > 	  
         	 	 < w w : i f   t e s t = " $ { c o u r s e m e m b e r = = n u l l } " >        
         	 	 	 < s p a n   i d = " d e s c r i p t i o n T e x t $ { r o w . i d } "   c l a s s = " c L a b e l " > < / s p a n >              
         	 	 < / w w : i f > 	  
                 < w w : e l s e >  
                 	 < s p a n   i d = " d e s c r i p t i o n T e x t $ { r o w . i d } "   c l a s s = " c L a b e l " > �]�e< f m t : f o r m a t D a t e   p a t t e r n = " y y y y - M M - d d   H H : m m "   v a l u e = " $ { c o u r s e m e m b e r . c r e a t e d D a t e } "   / > 1XTb�R! < / s p a n >              
                 < / w w : e l s e >  
             	  
              
         < / d i s p l a y : c o l u m n >  
          
         < d i s p l a y : c o l u m n   t i t l e K e y = " c o m m o n . a c t i o n " >  
         	 < w w : i f   t e s t = " $ { c o u r s e m e m b e r   = = n u l l } " >         	    
         	     < i n p u t   i d = " r e g i s t e r B u t t o n "   t y p e = " b u t t o n "   v a l u e = " 	cb1XT"   o n C l i c k = " j a v a s c r i p t : r e g i s t e r ( $ { r o w . i d } ) "   / >  
             < / w w : i f > 	  
             < w w : e l s e >  
             	 < i n p u t   i d = " r e g i s t e r B u t t o n "   t y p e = " b u t t o n "   v a l u e = " �S�m1XT"   o n C l i c k = " j a v a s c r i p t : r e g i s t e r ( $ { r o w . i d } ) " / >  
             < / w w : e l s e > 	                
         < / d i s p l a y : c o l u m n >  
         < c : s e t   v a r = " c o u n t "   v a l u e = " $ { c o u n t + 1 } "   / >  
         	  
          
         	  
         	  
 < / d i s p l a y : t a b l e >  
                 < / t d >  
         < / t r >  
             < t r   c l a s s = " c A c t i o n B u t t o n L i n e " >  
                 < t d    
                  
                 < / t d >  
             < / t r >  
 < / t a b l e >  
  
 < s c r i p t >  
 	 f u n c t i o n   r e g i s t e r ( c o u r s e ) {  
 	 	 / / a l e r t ( ' c o u r s e = ' + c o u r s e ) ;  
 	 	 	  
 	 	 	 $ . a j a x ( {  
                 u r l :   ' s a v e C o u r s e U s e r J S O N . d o ' ,  
                 t y p e :   " P O S T " ,                  
                 d a t a :   { " c o u r s e . i d " : c o u r s e } ,      
                 d a t a T y p e :   " j s o n " ,  
                 s u c c e s s :   f u n c t i o n ( d a t a )   {  
                 	 v a r   r e t u r n V a l u e = d a t a . r e t u r n V a l u e ;      
                 	 v a r   c r e a t e d D a t e = d a t a . c r e a t e d D a t e ;      
                 	 / / a l e r t ( ' r e t u r n V a l u e = ' + r e t u r n V a l u e + ' - - - c r e a t e d D a t e = ' + c r e a t e d D a t e ) ;  
                 	 i f ( r e t u r n V a l u e = = ' 1 ' ) {  
                 	 	       / / a l e r t ( ' 	g1XT' ) ;          
                 	 	       $ ( " # d e s c r i p t i o n T e x t " + c o u r s e ) . h t m l ( ' �]�e' + c r e a t e d D a t e + ' 1XTb�R! ' ) ;  
                 	 	       $ ( " # r e g i s t e r B u t t o n " ) . a t t r ( ' v a l u e ' ,   ' �S�m1XT' ) ;         	 	    
                 	 } e l s e {  
                 	 	   	   / / a l e r t ( ' !q1XT' ) ;  
                 	 	   	   $ ( " # d e s c r i p t i o n T e x t " + c o u r s e ) . h t m l ( ' ' ) ;  
                 	 	   	   $ ( " # r e g i s t e r B u t t o n " ) . a t t r ( ' v a l u e ' ,   ' 	cb1XT' ) ;  
                 	 }      
                 }  
             } ) ;  
              
 	 }  
 < / s c r i p t > 	      
      
  
  
  
  
 < / b o d y >  
 < / h t m l >  
 