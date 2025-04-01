package com.musictheory.eartrainer.util;

import org.tensorflow.Tensor;
import org.tensorflow.Session;
import org.tensorflow.Graph;
import java.nio.FloatBuffer;

public class MLModelUtil {

    public static float[] predict(float[] inputData, byte[] modelGraph) {
        try (Graph graph = new Graph()) {
            graph.importGraphDef(modelGraph);
            try (Session session = new Session(graph);
                 Tensor<Float> inputTensor = Tensor.create(new long[]{1, inputData.length}, FloatBuffer.wrap(inputData))) {
                Tensor<?> result = session.runner().feed("input_layer", inputTensor).fetch("output_layer").run().get(0);
                float[][] output = new float[1][];
                result.copyTo(output);
                return output[0];
            }
        }
    }
}
