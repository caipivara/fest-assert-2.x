/*
 * Created on May 9, 2013
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api;

import static org.fest.test.ExpectedException.none;

import java.math.BigDecimal;

import org.fest.assertions.description.Description;
import org.fest.assertions.internal.TestDescription;
import org.fest.test.ExpectedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link BigDecimalAssert#isNotEqualTo(String)}.
 *
 * @author: Yvonne Wang
 */
public class BigDecimalAssert_isNotEqualTo_Test {
  @Rule
  public ExpectedException thrown = none();
  private BigDecimalAssert assertions;
  private BigDecimal actual = new BigDecimal(8);
  private BigDecimal expected = new BigDecimal(6);
  private final Description description = new TestDescription("testing");

  @Before
  public void setUp() {
    assertions = new BigDecimalAssert(actual, description);
  }

  @Test
  public void should_return_this() {
    BigDecimalAssert returned = assertions.isNotEqualTo(expected);
    Assert.assertSame(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_String_expected() {
    assertions.isNotEqualTo("6");
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_expected() {
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_expected_with_different_scale() {
    expected = new BigDecimal(6.00);
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions = new BigDecimalAssert(actual);
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_fail_if_expected_is_null() {
    thrown.expect(NullPointerException.class);
    expected = null;
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_fail_if_actual_is_equal_to_expected() {
    thrown.expect(AssertionError.class);
    assertions.isNotEqualTo(new BigDecimal(8));
  }

  @Test
  public void should_fail_if_actual_is_equal_to_String_expected() {
    thrown.expect(AssertionError.class);
    assertions.isNotEqualTo("8");
  }
}
