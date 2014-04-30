import java.util.*;
import java.io.*;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;

class CityGraph extends UndirectedSparseGraph<City, Road> {
    static enum TokenT { NODE, EDGE, SEP }  // EDGE = "->", SEP = ";"
    static class Token {
        TokenT t;
        String s;
        int line;
        
        public Token(TokenT typ, String str, int l) { t = typ; s = str; line = l; }
    }
    
    public Road addRoad(int length, City c1, City c2) {
        Road r = findEdge(c1, c2);
        if (r != null) {
            r.length = length;
            return r;
        }
        r = new Road(length);
        addEdge(r, c1, c2);
        return r;
    }
    
    public void parse(String file, Reader input) throws IOException {
        if (!input.markSupported()) {
            input = new BufferedReader(input);
        }
        
        ArrayList<Token> tokens = lex(file, input);
        
        // Graph definition follows the pattern:
        // (NODE (EDGE NODE)+ SEP)*
        
        int lastNode, nextNode;
        City lastCity, nextCity;
        
        for (int i = 0; i < tokens.size(); i++) {
            Token tok = tokens.get(i);
            
            // bare separator (empty line)
            if (tok.t == TokenT.SEP) {
                continue;
            }
            
            if (tok.t != TokenT.NODE) {
                String err = String.format("%s: %d: path must start with a node", file, tok.line);
                throw new RuntimeException(err);
            }
            
            try {
                lastNode = Integer.parseInt(tok.s);
            } catch (NumberFormatException fail) {
                String err = String.format("%s: %d: can't parse node id (%s)", file, tok.line, tok.s);
                throw new RuntimeException(err);
            }
            lastCity = new City(lastNode);
            addVertex(lastCity);
            
            i++;
            tok = tokens.get(i);
            do {
                if (tok.t != TokenT.EDGE) {
                    String err = String.format("%s: %d: expected '->', found '%s'", file, tok.line, tok.s);
                    throw new RuntimeException(err);
                }
                
                i++;
                tok = tokens.get(i);
                if (tok.t != TokenT.NODE) {
                    String err = String.format("%s: %d: expected a node id, found '%s'", file, tok.line, tok.s);
                    throw new RuntimeException(err);
                }
                
                try {
                    nextNode = Integer.parseInt(tok.s);
                } catch (NumberFormatException fail) {
                    String err = String.format("%s: %d: can't parse node id (%s)", file, tok.line, tok.s);
                    throw new RuntimeException(err);
                }
                nextCity = new City(nextNode);
                addVertex(nextCity);
                
                addRoad(1, lastCity, nextCity);
                lastNode = nextNode;
                lastCity = nextCity;
                
                i++;
                tok = tokens.get(i);
            } while (tok.t != TokenT.SEP);
        }
    }
    
    ArrayList<Token> lex(String file, Reader input) throws IOException {
        StringBuilder buf = new StringBuilder();
        ArrayList<Token> tokens = new ArrayList<Token>();
        int line = 1;
        int ch;
        
        // The lexer expects the input to match this pseudo-patern:
        // (node_id ('->' | ';')? )+
        // where node_id is a number
        
        for (;;) {
            // skip whitespace
            do {
                input.mark(1024);
                ch = input.read();
                if (ch == '\n') { line++; }
            } while (ch == ' ' || ch == '\t' || ch == '\n');
            input.reset();
            
            ch = input.read();
            if (ch == -1) { break; }
            
            // we expect a node id now
            if ("0123456789".indexOf(ch) == -1) {
                String err = String.format("%s: %d: invalid character (%c) in node identifier", file, line, ch);
                throw new RuntimeException(err);
            }
            
            // read the entire id
            while ("0123456789".indexOf(ch) != -1) {
                buf.appendCodePoint(ch);
                ch = input.read();
            }
            
            tokens.add(new Token(TokenT.NODE, buf.toString(), line));
            buf.setLength(0);
            
            while (ch == ' ' || ch == '\t') {
                ch = input.read();
            }
            
            if (ch == -1) { break; }
            
            // after a node, we expect either an edge ("->") or a path separator (";")
            // is this an edge?
            if (ch == '-') {
                ch = input.read();
                if (ch != '>') {
                    String err = String.format("%s: %d: invalid character (-) after node indentifier", file, line);
                    throw new RuntimeException(err);
                }
                tokens.add(new Token(TokenT.EDGE, "->", line));
                continue;
            }
            
            if (ch == ';') {
                tokens.add(new Token(TokenT.SEP, ";", line));
                continue;
            }
            
            if (ch == '\n') {
                line++;
                continue;
            }
            
            String err = String.format("%s: %d: invalid character (%c) after node identifier", file, line, ch);
            throw new RuntimeException(err);
        }
        
        tokens.add(new Token(TokenT.SEP, ";", line));
        
        return tokens;
    }
    
    public void render() {}
}