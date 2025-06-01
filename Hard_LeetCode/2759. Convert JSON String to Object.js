/**
 * @param {string} str
 * @return {null|boolean|number|string|Array|Object}
 */
const jsonParse = (str) => {
   let i = 0;

   const parseValue = () => {
      switch (str[i]) {
         case '"':
            return parseString();
         case '{':
            return parseObject();
         case '[':
            return parseArray();
         case 't':
         case 'f':
         case 'n':
            return parseLiteral();
         default:
            return parseNumber();
      }
   };

   const parseNumber = () => {
      let start = i;

      if (str[i] === '-') {
         i++;
      }

      while (i < str.length && isDigit(str[i])) {
         i++;
      }

      if (str[i] === '.') {
         i++;
         while (i < str.length && isDigit(str[i])) {
            i++;
         }
      }

      return Number(str.slice(start, i));
   };

   const isDigit = (n) => n >= '0' && n <= '9';

   const parseString = () => {
      let result = '';
      i++;

      while (i < str.length && str[i] !== '"') {
         result += str[i];
         i++;
      }

      i++;
      return result;
   };

   const parseObject = () => {
      i++;
      const result = {};

      while (i < str.length && str[i] !== '}') {
         const key = parseString();
         expectChar(':');
         const value = parseValue();
         result[key] = value;

         if (str[i] === ',') {
            i++;
         }
      }

      i++;
      return result;
   };

   const parseArray = () => {
      i++;
      const result = [];

      while (i < str.length && str[i] !== ']') {
         const value = parseValue();
         result.push(value);

         if (str[i] === ',') {
            i++;
         }
      }

      i++;
      return result;
   };

   const parseLiteral = () => {
      if (str.startsWith('true', i)) {
         i += 4;
         return true;
      } else if (str.startsWith('false', i)) {
         i += 5;
         return false;
      } else if (str.startsWith('null', i)) {
         i += 4;
         return null;
      }
   };

   const expectChar = (char) => {
      if (str[i] !== char) {
         throw new Error(`Expected '${char}' at position ${i}`);
      }
      i++;
   };

   return parseValue();
};
