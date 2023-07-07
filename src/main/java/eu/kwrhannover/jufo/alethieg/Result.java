package eu.kwrhannover.jufo.alethieg;

import java.nio.file.Path;
import java.util.Objects;

public class Result {

    public enum DiagnosticFinding {
        POSITIVE,
        NEGATIVE,
        UNKNOWN
    }

    private final Path sourceFile;
    private final DiagnosticFinding analysisResult;
    private final double analysisValue;
    // stores the probablility that the species is positive
    private final double positiveProbability;

    public Result(Path sourceFile, DiagnosticFinding analysisResult, double analysisValue, double positiveProbability) {
        this.sourceFile = sourceFile;
        this.analysisResult = analysisResult;
        this.analysisValue = analysisValue;
        
        this.positiveProbability = positiveProbability;
    }

    public Path getSourceFile() {
        return sourceFile;
    }

    public DiagnosticFinding getAnalysisResult() {
        return analysisResult;
    }

    public double getAnalysisValue() {
        return analysisValue;
    }

    public double getPositiveProbability(){
        return positiveProbability;
    }

    @Override
    public String toString() {
        return "Result{" +
                "sourceFile=" + sourceFile +
                ", analysisResult=" + analysisResult +
                ", analysisValue=" + analysisValue +
                ", positiveProbability=" + positiveProbability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Double.compare(result.analysisValue, analysisValue) == 0 && sourceFile.equals(result.sourceFile) && analysisResult == result.analysisResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceFile, analysisResult, analysisValue);
    }
}