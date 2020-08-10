package sean.math.physics.ballistics;

import sean.math.geometry.Vector3;
import sean.math.solve.Solver;

public class BallisticsSolver {
    Solver solve = new Solver();
    public static float ballisticRange(float speed, float gravity, float initial_height) {

        // Handling these cases is up to your project's coding standards
        //System.out.assert(speed > 0 && gravity > 0 && initial_height >= 0, "fts.ballistic_range called with invalid data");

        if(!(speed > 0 && gravity > 0 && initial_height >= 0)){
            System.out.println("BallisticsSolver.ballisticRange called with invalid parameters");
        }
        // Derivation
        //   (1) x = speed * time * cos O
        //   (2) y = initial_height + (speed * time * sin O) - (.5 * gravity*time*time)
        //   (3) via quadratic: t = (speed*sin O)/gravity + sqrt(speed*speed*sin O + 2*gravity*initial_height)/gravity    [ignore smaller root]
        //   (4) solution: range = x = (speed*cos O)/gravity * sqrt(speed*speed*sin O + 2*gravity*initial_height)    [plug t back into x=speed*time*cos O]
        //float angle = 45 * (float)Math.deg2rad; // no air resistance, so 45 degrees provides maximum range
        float angle = (float)Math.toRadians(45);
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);

        float range = (speed*cos/gravity) * (speed*sin + (float)Math.sqrt(speed*speed*sin*sin + 2*gravity*initial_height));
        return range;
    }
    // Solve firing angles for a ballistic projectile with speed and gravity to hit a fixed position.
    //
    // proj_pos (Vector3): point projectile will fire from
    // proj_speed (float): scalar speed of projectile
    // target (Vector3): point projectile is trying to hit
    // gravity (float): force of gravity, positive down
    //
    // s0 (out Vector3): firing solution (low angle) 
    // s1 (out Vector3): firing solution (high angle)
    //
    // return (int): number of unique solutions found: 0, 1, or 2.
    public static BallisticsOut solve_ballistic_arc(Vector3 proj_pos, float proj_speed, Vector3 target, float gravity) {

        // Handling these cases is up to your project's coding standards
        //todo Debug.Assert(proj_pos != target && proj_speed > 0 && gravity > 0, "fts.solve_ballistic_arc called with invalid data");

        // C# requires out variables be set
        Vector3 s0 = Vector3.ZERO;
        Vector3 s1 = Vector3.ZERO;
        BallisticsOut out = new BallisticsOut();

        // Derivation
        //   (1) x = v*t*cos O
        //   (2) y = v*t*sin O - .5*g*t^2
        // 
        //   (3) t = x/(cos O*v)                                        [solve t from (1)]
        //   (4) y = v*x*sin O/(cos O * v) - .5*g*x^2/(cos^2 O*v^2)     [plug t into y=...]
        //   (5) y = x*tan O - g*x^2/(2*v^2*cos^2 O)                    [reduce; cos/sin = tan]
        //   (6) y = x*tan O - (g*x^2/(2*v^2))*(1+tan^2 O)              [reduce; 1+tan O = 1/cos^2 O]
        //   (7) 0 = ((-g*x^2)/(2*v^2))*tan^2 O + x*tan O - (g*x^2)/(2*v^2) - y    [re-arrange]
        //   Quadratic! a*p^2 + b*p + c where p = tan O
        //
        //   (8) let gxv = -g*x*x/(2*v*v)
        //   (9) p = (-x +- sqrt(x*x - 4gxv*(gxv - y)))/2*gxv           [quadratic formula]
        //   (10) p = (v^2 +- sqrt(v^4 - g(g*x^2 + 2*y*v^2)))/gx        [multiply top/bottom by -2*v*v/x; move 4*v^4/x^2 into root]
        //   (11) O = atan(p)
        Vector3 diff = target.subtract(proj_pos);
        Vector3 diffXZ = new Vector3(diff.getX(), 0f, diff.getY());
        float groundDist = diffXZ.length();

        float speed2 = proj_speed*proj_speed;
        float speed4 = proj_speed*proj_speed*proj_speed*proj_speed;
        float y = diff.getY();
        float x = groundDist;
        float gx = gravity*x;

        float root = speed4 - gravity*(gravity*x*x + 2*y*speed2);

        // No solution
        if (root < 0){
            out.s0 = s0;
            out.s1 = s1;
            out.solve = 0;
            return out;
        }
        System.out.println(diff.toString());

        root = (float)Math.sqrt(root);

        float lowAng = (float)Math.atan2(speed2 - root, gx);
        float highAng = (float)Math.atan2(speed2 + root, gx);
        int numSolutions = lowAng != highAng ? 2 : 1;

        Vector3 groundDir = diffXZ.normalize();
        s0 = groundDir.scale((float)Math.cos(lowAng)).scale(proj_speed).add(Vector3.Up.scale((float)Math.sin(lowAng)).scale(proj_speed));
        if (numSolutions > 1)
            s1 = groundDir.scale((float)Math.cos(highAng)).scale(proj_speed).add(Vector3.Up.scale((float)Math.sin(highAng)).scale(proj_speed));

        System.out.println(s0.toString());
        System.out.println(s1.toString());
        out.s0 = s0;
        out.s1 = s1;
        out.solve = numSolutions;
        return out;
    }
    public static void main(String args[]){
        BallisticsOut solve = BallisticsSolver.solve_ballistic_arc(new Vector3(0,0,0), 10, new Vector3(20,20,0), 1);
        System.out.println(solve.s1.toString());
        System.out.println(BallisticsSolver.ballisticRange(10,10,0));
    }
}