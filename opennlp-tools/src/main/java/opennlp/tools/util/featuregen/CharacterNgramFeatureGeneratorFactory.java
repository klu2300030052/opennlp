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

import opennlp.tools.util.InvalidFormatException;

/**
 * A {@link GeneratorFactory} that produces {@link CharacterNgramFeatureGenerator} instances
 * when {@link #create()} is called.
 *
 * @see CharacterNgramFeatureGenerator
 */
public class CharacterNgramFeatureGeneratorFactory
    extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {

  public CharacterNgramFeatureGeneratorFactory() {
    super();
  }

  @Override
  public AdaptiveFeatureGenerator create() throws InvalidFormatException {
    return new CharacterNgramFeatureGenerator(getInt("min"), getInt("max"));
  }
}
