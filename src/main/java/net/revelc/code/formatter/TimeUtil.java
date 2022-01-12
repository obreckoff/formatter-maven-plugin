/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.revelc.code.formatter;

public final class TimeUtil {

    /**
     * Prints the duration in a human-readable format as X minutes, Y seconds etc.
     *
     * @param duration
     *            the duration in millis
     *
     * @return the time used for displaying on screen or in logs
     */
    public static String printDuration(long duration) {
        if (duration <= 0) {
            return "0ms";
        }

        StringBuilder sb = new StringBuilder();

        long seconds = duration / 1000;
        long minutes = seconds / 60;
        if (minutes > 0) {
            sb.append(minutes % 60).append("m");
        }
        if (minutes + seconds > 0) {
            sb.append(seconds % 60).append("s");
        }

        long millis = duration % 1000;
        if (duration < 1000 || millis > 0) {
            // append millis if the duration is less than a second,
            // for duration longer than a second then only include millis if not zero
            sb.append(duration % 1000).append("ms");
        }

        return sb.toString();
    }

}