package com.ejercicio01.modelo;

import java.util.*;

public class Modelo {
    private ArrayList<Double> numerosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOperaciones;
    private StringBuilder operacion = new StringBuilder();
    private StringBuilder historial = new StringBuilder();

    {
        simbolosOperaciones = new ArrayList<>(Arrays.asList('+', '-', 'x', '/'));
    }

    public Modelo() {
        operacion.append("0");
    }

    public Modelo(String nuevaEntrada) {
        operacion.append(nuevaEntrada);
    }

    public void setEntrada(String entrada) {
        if (operacion.toString().equals("Error")) {
            operacion.setLength(0);
        } else if (operacion.toString().equals("0")) {
            if (!entrada.equals(".")) {
                operacion.setLength(0);
            }
        }
        operacion.append(entrada);
    }

    public String getOperacion() {
        return operacion.toString();
    }

    public void leerYOperar(String parteOperacion) {
        StringBuilder numDecimal = new StringBuilder();
        numerosOp.clear();
        simbolosOp.clear();
        char[] partesOper = parteOperacion.toCharArray();

        for (int i = 0; i < partesOper.length; i++) {
            Character caracterOp = partesOper[i];
            if (Character.isDigit(caracterOp) || caracterOp == '.'
                    || (caracterOp == '-' && (i == 0 || Character.isDigit(partesOper[i + 1])))) {
                numDecimal.append(caracterOp);
            } else if (simbolosOperaciones.contains(caracterOp)) {
                agregarNumero(numDecimal);
                simbolosOp.add(caracterOp);
            }
        }

        agregarNumero(numDecimal);
        operar(numerosOp, simbolosOp);
    }

    private void agregarNumero(StringBuilder numDecimal) {
        if (numDecimal.length() > 0) {
            try {
                numerosOp.add(Double.parseDouble(numDecimal.toString()));
            } catch (NumberFormatException e) {
                manejarError(e);
            }
            numDecimal.setLength(0);
        }
    }

    public void operar(ArrayList<Double> numeros, ArrayList<Character> simbolos) {
        try {
            ArrayList<Double> resultados = new ArrayList<>(numeros);
            ArrayList<Character> ops = new ArrayList<>(simbolos);

            procesarOperaciones(resultados, ops, '^', '$');
            procesarOperaciones(resultados, ops, 'x', '/');
            procesarOperaciones(resultados, ops, '+', '-');

            if (resultados.size() == 1) {
                String operacionTxt = operacion.toString();
                double resultadoDouble = resultados.get(0);
                actualizarOperacion(resultadoDouble);
                historial.append("\n&" + operacionTxt + " = " + operacion.toString());
                System.out.println(historial.toString());
            } else {
                throw new IllegalStateException("Operación no válida");
            }
        } catch (Exception e) {
            manejarError(e);
        }
    }

    private void procesarOperaciones(ArrayList<Double> numeros, ArrayList<Character> simbolos, char op1, char op2) {
        for (int i = 0; i < simbolos.size(); i++) {
            char simbolo = simbolos.get(i);
            if (simbolo == op1 || simbolo == op2) {
                double resultado = realizarOperacion(numeros.get(i), numeros.get(i + 1), simbolo);
                numeros.set(i, resultado);
                numeros.remove(i + 1);
                simbolos.remove(i);
                i--;
            }
        }
    }

    private double realizarOperacion(double num1, double num2, char operador) {
        switch (operador) {
            case 'x':
                return multiplicar(num1, num2);
            case '/':
                return dividir(num1, num2);
            case '+':
                return sumar(num1, num2);
            case '-':
                return restar(num1, num2);
            case '^':
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }

    public double sumar(double op1, double op2) {
        return op1 + op2;
    }

    public double restar(double op1, double op2) {
        return op1 - op2;
    }

    public double multiplicar(double op1, double op2) {
        return op1 * op2;
    }

    public double dividir(double op1, double op2) {
        if (op2 == 0) {
            throw new ArithmeticException("División por cero");
        }
        return op1 / op2;
    }

    public void fraccion(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = 1 / ultimoNumero;
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = " + "(1/" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void elevar(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.pow(ultimoNumero, 2);
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = " + "(" + ultimoNumero + "^2) // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void raiz(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.sqrt(ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append(
                "\n& " + resultado + " = " + "(\u221A" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void porcentaje(String operacion) {
        try {
            String[] partes = operacion.split(" ");
            if (partes.length >= 3) {
                double numPorcentual = Double.parseDouble(partes[partes.length - 1]);
                double numOperador = Double.parseDouble(partes[partes.length - 3]);
                double porcentaje = (numOperador / 100) * numPorcentual;
                actualizarUltimoValor(porcentaje);
                historial.append("\n& " + porcentaje + " = " + "(" + numPorcentual + "% de " + numOperador
                        + ") // Pertenece a la siguiente operación");
                System.out.println(historial.toString());
            }
        } catch (ArithmeticException e) {
            manejarError(e);
        }
    }

    public void cambiarSentido(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = -ultimoNumero;
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = " + "(-" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public int cogerIndice() {
        int indice = -1;
        try {
            indice = (operacion.toString().split(" ").length == 0) ? -1
                    : (operacion.toString().split(" ").length > 1) ? numerosOp.size() - 1 : 0;
        } catch (Exception e) {
            manejarError(e);
        }
        return indice;
    }

    private String recogerUltimoValor(String operacion) {
        String[] partesOperacion = operacion.toString().split(" ");
        return partesOperacion[partesOperacion.length - 1];
    }

    private void actualizarUltimoValor(double resultado) {
        String[] operacionSeparada = operacion.toString().split(" ");
        if (entero(resultado)) {
            operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) resultado));
        } else {
            operacionSeparada[operacionSeparada.length - 1] = String.valueOf(resultado);
        }
        operacion = new StringBuilder(String.join(" ", operacionSeparada));
    }

    public void actualizarOperacion(double nuevoResultado) {
        operacion.setLength(0);
        if (entero(nuevoResultado)) {
            operacion.append(((int) nuevoResultado));
        } else {
            operacion.append(nuevoResultado);
        }
    }

    public void limpiarOperacionYHistorial() {
        operacion.setLength(0);
        historial.setLength(0);
        operacion.append("0");
    }

    public void limpiarOperacion() {
        operacion.setLength(0);
        operacion.append("0");
    }

    public void borrarUno() {
        try {
            operacion.setLength(operacion.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("No hay más operación");
        }
    }

    public boolean entero(double numero) {
        return ((int) numero) == numero;
    }

    private void manejarError(Exception e) {
        operacion.setLength(0);
        operacion.append("Error");
        e.printStackTrace();
    }
}