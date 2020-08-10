package sean.math.solve;

public class Solver {
    public static boolean IsZero(double d) {
        double eps = 1e-9;
        return d > -eps && d < eps;
    }
    public static SolveOutput solveQuadric(double c0, double c1, double c2){
        double s0;
        double s1;

        SolveOutput out = new SolveOutput();

        double p, q, D;

        p = c1 / (2 * c0);
        q = c2 / c0;

        D = p * p - q;

        if (IsZero(D)) {
            s0 = -p;
            out.s0 = s0;
            out.solve = 1;
	        return out;//1;
        }
        else if (D < 0) {
            out.solve = 0;
	        return out;
        }
        else /* if (D > 0) */ {
	        double sqrt_D = Math.sqrt(D);

	        s0 =   sqrt_D - p;
            s1 = -sqrt_D - p;
            out.s0 = s0;
            out.s1 = s1;
            out.solve = 2;
	        return out;
        }
    }
        // Solve cubic equation: c0*x^3 + c1*x^2 + c2*x + c3. 
    // Returns number of solutions.
    public static SolveOutput solveCubic(double c0, double c1, double c2, double c3){
        double s0 = Double.NaN;
        double s1 = Double.NaN;
        double s2 = Double.NaN;

        SolveOutput out = new SolveOutput();
        int     num;
        double  sub;
        double  A, B, C;
        double  sq_A, p, q;
        double  cb_p, D;

        /* normal form: x^3 + Ax^2 + Bx + C = 0 */
        A = c1 / c0;
        B = c2 / c0;
        C = c3 / c0;

        /*  substitute x = y - A/3 to eliminate quadric term:  x^3 +px + q = 0 */
        sq_A = A * A;
        p = 1.0/3 * (- 1.0/3 * sq_A + B);
        q = 1.0/2 * (2.0/27 * A * sq_A - 1.0/3 * A * B + C);

        /* use Cardano's formula */
        cb_p = p * p * p;
        D = q * q + cb_p;

        if (IsZero(D)) {
	        if (IsZero(q)) /* one triple solution */ {
	            s0 = 0;
	            num = 1;
	        }
	        else /* one single and one double solution */ {
	            double u = Math.pow(-q, 1.0/3.0);
	            s0 = 2 * u;
	            s1 = - u;
	            num = 2;
	        }
        }
        else if (D < 0) /* Casus irreducibilis: three real solutions */ {
	        double phi = 1.0/3 * Math.acos(-q / Math.sqrt(-cb_p));
	        double t = 2 * Math.sqrt(-p);

	        s0 =   t * Math.cos(phi);
	        s1 = - t * Math.cos(phi + Math.PI / 3);
	        s2 = - t * Math.cos(phi - Math.PI / 3);
	        num = 3;
        }
        else /* one real solution */ {
	        double sqrt_D = Math.sqrt(D);
	        double u = Math.pow(sqrt_D - q, 1.0/3.0);
	        double v = - Math.pow(sqrt_D + q, 1.0/3.0);

	        s0 = u + v;
	        num = 1;
        }

        /* resubstitute */
        sub = 1.0/3 * A;

        if (num > 0)    s0 -= sub;
        if (num > 1)    s1 -= sub;
        if (num > 2)    s2 -= sub;
        out.s0 = s0;
        out.s1 = s1;
        out.s2 = s2;
        out.solve = num;
        return out;
    }
    public static SolveOutput solveQuartic(double c0, double c1, double c2, double c3, double c4) {
        double s0 = Double.NaN;
        double s1 = Double.NaN;
        double s2 = Double.NaN;
        double s3 = Double.NaN;

        SolveOutput realOut = new SolveOutput();
        double[]  coeffs = new double[4];
        double  z, u, v, sub;
        double  A, B, C, D;
        double  sq_A, p, q, r;
        int     num;

        /* normal form: x^4 + Ax^3 + Bx^2 + Cx + D = 0 */
        A = c1 / c0;
        B = c2 / c0;
        C = c3 / c0;
        D = c4 / c0;

        /*  substitute x = y - A/4 to eliminate cubic term: x^4 + px^2 + qx + r = 0 */
        sq_A = A * A;
        p = - 3.0/8 * sq_A + B;
        q = 1.0/8 * sq_A * A - 1.0/2 * A * B + C;
        r = - 3.0/256*sq_A*sq_A + 1.0/16*sq_A*B - 1.0/4*A*C + D;

        if (IsZero(r)) {
	        /* no absolute term: y(y^3 + py + q) = 0 */

	        coeffs[ 3 ] = q;
	        coeffs[ 2 ] = p;
	        coeffs[ 1 ] = 0;
	        coeffs[ 0 ] = 1;

            SolveOutput out = solveCubic(coeffs[0], coeffs[1], coeffs[2], coeffs[3]);
            num = out.solve;
            s0 = out.s0;
            s1 = out.s1;
            s2 = out.s2;
	        //num = solveCubic(coeffs[0], coeffs[1], coeffs[2], coeffs[3], out s0, out s1, out s2);
        }
        else {
	        /* solve the resolvent cubic ... */
	        coeffs[ 3 ] = 1.0/2 * r * p - 1.0/8 * q * q;
	        coeffs[ 2 ] = - r;
	        coeffs[ 1 ] = - 1.0/2 * p;
	        coeffs[ 0 ] = 1;

            SolveOutput out = solveCubic(coeffs[0], coeffs[1], coeffs[2], coeffs[3]);
            s0 = out.s0;
            s1 = out.s1;
            s2 = out.s2;
	        /* ... and take the one real solution ... */
	        z = s0;

	        /* ... to build two quadric equations */
	        u = z * z - r;
	        v = 2 * z - p;

	        if (IsZero(u))
	            u = 0;
	        else if (u > 0)
	            u = Math.sqrt(u);
	        else{
                realOut.solve = 0;
                return realOut;
            }

	        if (IsZero(v))
	            v = 0;
	        else if (v > 0)
	            v = Math.sqrt(v);
	        else{
                realOut.solve = 0;
                return realOut;
            }

	        coeffs[ 2 ] = z - u;
	        coeffs[ 1 ] = q < 0 ? -v : v;
	        coeffs[ 0 ] = 1;

            SolveOutput outs = solveQuadric(coeffs[0], coeffs[1], coeffs[2]);
            num = outs.solve;
            s0 = outs.s0;
            s1 = outs.s1;
            //num = solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s0, out s1);

	        coeffs[ 2 ]= z + u;
	        coeffs[ 1 ] = q < 0 ? v : -v;
	        coeffs[ 0 ] = 1;

            if (num == 0){
                SolveOutput out0 = solveQuadric(coeffs[0], coeffs[1], coeffs[2]);
                num += out0.solve;
                s0 = out0.s0;
                s1 = out0.s1;
                //num += solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s0, out s1);
            }
            if (num == 1){
                SolveOutput out1 = solveQuadric(coeffs[0], coeffs[1], coeffs[2]);
                num += out1.solve;
                s1 = out1.s0;
                s2 = out1.s1;
                //num += solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s0, out s1);
            }
            if (num == 1){
                SolveOutput out2 = solveQuadric(coeffs[0], coeffs[1], coeffs[2]);
                num += out2.solve;
                s2 = out2.s0;
                s3 = out2.s1;
                //num += solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s0, out s1);
            }
            //if (num == 1) num += solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s1, out s2);
            //if (num == 2) num += solveQuadric(coeffs[0], coeffs[1], coeffs[2], out s2, out s3);
        }

        /* resubstitute */
        sub = 1.0/4 * A;

        if (num > 0)    s0 -= sub;
        if (num > 1)    s1 -= sub;
        if (num > 2)    s2 -= sub;
        if (num > 3)    s3 -= sub;
        realOut.s0 = s0;
        realOut.s1 = s1;
        realOut.s2 = s2;
        realOut.s3 = s3;
        realOut.solve = num;
        return realOut;
    }
}