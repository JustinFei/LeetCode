public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int result = (C - A) * (D - B) + (G - E) * (H - F); //Sum of areas of two rectangles
    if(C <= E || G <= A || H <= B || D <= F) return result; //If no overlap at all.
    int dx = Math.min(C, G) - Math.max(A, E); //Overlap length along x
    int dy = Math.min(D, H) - Math.max(B, F); //Overlap length along y
    return result - dx * dy;
}
-----------------------------------
public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = Math.abs((D-B)*(C-A));
    int area2 = Math.abs((G-E)*(H-F));
    int repeat_h = Math.max(B,F)>Math.min(D,H) ? 0 : Math.min(D,H)-Math.max(B, F);
    int repeat_w = Math.max(A,E)>Math.min(C,G) ? 0 : Math.min(C,G)-Math.max(A, E);
    return area1+area2-(repeat_h*repeat_w);
}