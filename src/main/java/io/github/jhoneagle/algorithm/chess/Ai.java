package io.github.jhoneagle.algorithm.chess;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Ai implements Player {
    private Evaluator evaluator; // current evaluator
    private int color; // 0 is white and 1 is black

    public Ai() {
    }

    public Ai(Evaluator evaluator, int color) {
        this.evaluator = evaluator;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public State makeAMove(State p){


        return null;
    }

    class StateComparator implements Comparator<State> {
        public int compare(State p1, State p2) {
            return Double.compare(eval(p1), eval(p2));
        }
    }

    private double eval(State p) {
        if (!Double.isNaN(p.getCachedResult())) return p.getCachedResult();

        double d = 0.0;
        d = evaluator.eval(p);
        p.setCachedResult(d);

        return d;
    }

    private double alphabeta(State p, int depth, double alpha, double beta, int player) {
        // 0 tries to maximize, 1 tries to minimize
        if (p.getWinner() == -1) return -1E10-depth; // prefer to win sooner
        if (p.getWinner() == +1) return +1E10+depth; // and lose later

        if(depth == 0) return evaluator.eval(p);

        Vector<State> P = p.getNextPositions();
        Collections.sort(P, (new Ai()).new StateComparator());

        if(player == 0) Collections.reverse(P);

        if(player == 0) {
            for(int i = 0; i < P.size(); ++i) {
                alpha = Math.max(alpha, alphabeta(P.elementAt(i),depth-1,alpha,beta,1));

                if(beta <= alpha) break;
            }

            return alpha;
        }

        for(int i = 0; i < P.size(); ++i) {
            beta = Math.min(beta,alphabeta(P.elementAt(i),depth-1,alpha,beta,0));

            if(beta <= alpha) break;
        }

        return beta;
    }

    private double minmax(State p, int depth, int player) {
        double alpha = -Double.MAX_VALUE, beta = Double.MAX_VALUE;

        return alphabeta(p,depth,alpha,beta,player);
		/*
		//return (p.whiteToMove ? -1 : 1) * eval(p);
		if(depth <= 0) return eval(p);

		double val = eval(p);
		if(Math.abs(val) > 1e8) return val; // prevent king exchange :/

		double alpha = p.whiteToMove ? 1e12 : -1e12;

		Vector<Position> P = p.getNextPositions();

		for(int i = 0; i < P.size(); ++i) {
			if(p.whiteToMove) {
				alpha = Math.min(alpha, minmax(P.elementAt(i),depth-1));
			} else alpha = Math.max(alpha, minmax(P.elementAt(i),depth-1));
		}

		return alpha;
		*/
    }


}
