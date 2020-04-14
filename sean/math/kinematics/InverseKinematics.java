package sean.math.kinematics;

import java.util.ArrayList;

import sean.math.geometry.PolarPoint2d;

public class InverseKinematics {
    ArrayList<PolarPoint2d> m_vectors;
    public InverseKinematics(ArrayList<PolarPoint2d> vectors){
        m_vectors = vectors;
    }
    public ArrayList<PolarPoint2d> getVectors(){
        return m_vectors;
    }
    public PolarPoint2d getVector(int i){
        return m_vectors.get(i);
    }
    public void kinemat(int x, int y){
        
    }
}