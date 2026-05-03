/** @type {import('ts-jest').JestConfigWithTsJest} */
module.exports = {
  testEnvironment: 'node',
  // אומר ל-Jest להשתמש ב-Preset הייעודי ל-ESM
  preset: 'ts-jest/presets/default-esm', 
  moduleNameMapper: {
    // זה הקסם: הוא אומר ל-Jest שאם הוא רואה ייבוא שמסתיים ב-.js, 
    // הוא צריך לחפש את קובץ המקור (שעשוי להיות .ts) בלי הסיומת
    '^(\\.{1,2}/.*)\\.js$': '$1',
  },
  transform: {
    // מגדיר את המרת הקבצים לשימוש ב-ESM
    '^.+\\.tsx?$': [
      'ts-jest',
      {
        useESM: true,
      },
    ],
  },
};