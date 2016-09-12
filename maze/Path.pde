public class Path{

  int lOffset, hOffset, wd, ht;
  
  public Path(int lo, int ho, int w, int h){
  
    this.lOffset = lo;
    this.hOffset = ho;
    this.wd = w;
    this.ht = h;

  }
  
  
  void draw(){
    fill(0);
    rect(lOffset, hOffset, wd, ht);
  
  }

}