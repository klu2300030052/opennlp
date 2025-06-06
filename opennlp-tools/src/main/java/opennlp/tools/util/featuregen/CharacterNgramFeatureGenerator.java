/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.tools.util.featuregen;

import java.util.List;

import opennlp.tools.ngram.NGramModel;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;

/**
 * The {@link CharacterNgramFeatureGenerator} uses character ngrams to
 * generate features about each token.
 *
 * @see AdaptiveFeatureGenerator
 */
public class CharacterNgramFeatureGenerator implements AdaptiveFeatureGenerator {

  private static final String PREFIX = "ng=";

  private final int minLength;
  private final int maxLength;

  /**
   * Initializes a {@link CharacterNgramFeatureGenerator} with the specified parameters.
   *
   * @param minLength The minimum length to use. Must not be negative.
   * @param maxLength The maximum length to use. Must not be negative.
   */
  public CharacterNgramFeatureGenerator(int minLength, int maxLength) {
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

  /**
   * Initializes a {@link CharacterNgramFeatureGenerator} with default values for ngrams.
   * The minimal length is set to {@code 2} and maximum length to a value of {@code 5}.
   */
  public CharacterNgramFeatureGenerator() {
    this(2, 5);
  }

  @Override
  public void createFeatures(List<String> features, String[] tokens, int index, String[] preds) {
    NGramModel model = new NGramModel();
    model.add(tokens[index], minLength, maxLength);

    for (StringList tokenList : model) {
      if (tokenList.size() > 0) {
        features.add(PREFIX + StringUtil.toLowerCase(tokenList.getToken(0)));
      }
    }
  }
}
