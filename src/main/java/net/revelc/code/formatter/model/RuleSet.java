/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.revelc.code.formatter.model;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.RuleSetBase;

/**
 * An Apache Commons Digester RuleSet for configuring a digester to parse the Eclipse formatter config XML into objects.
 */
class RuleSet extends RuleSetBase {

    /** The Constant PROFILES_PROFILE. */
    private static final String PROFILES_PROFILE = "profiles/profile";

    /** The Constant PROFILES_PROFILE_SETTING. */
    private static final String PROFILES_PROFILE_SETTING = RuleSet.PROFILES_PROFILE + "/setting";

    /**
     * Adds the rule instances.
     *
     * @param digester
     *            the digester
     *
     * @see org.apache.commons.digester3.RuleSetBase#addRuleInstances(org.apache.commons.digester3.Digester)
     */
    @Override
    public void addRuleInstances(final Digester digester) {
        digester.addObjectCreate("profiles", Profiles.class);
        digester.addObjectCreate(RuleSet.PROFILES_PROFILE, Profile.class);
        digester.addObjectCreate(RuleSet.PROFILES_PROFILE_SETTING, Setting.class);

        digester.addSetNext(RuleSet.PROFILES_PROFILE, "addProfile");
        digester.addSetNext(RuleSet.PROFILES_PROFILE_SETTING, "addSetting");

        digester.addSetProperties(RuleSet.PROFILES_PROFILE, "kind", "kind");
        digester.addSetProperties(RuleSet.PROFILES_PROFILE_SETTING, "id", "id");
        digester.addSetProperties(RuleSet.PROFILES_PROFILE_SETTING, "value", "value");
    }

}
