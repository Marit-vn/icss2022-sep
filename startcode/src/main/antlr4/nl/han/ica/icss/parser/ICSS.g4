grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//Literals
TRUE: 'TRUE';
FALSE: 'FALSE';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;


//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';

// --- Booleaanse expressies: ---
NOT: '!';
EQUALS: '==';
GREATERTHAN: '>';
SMALLERTHAN: '<';

// --- Level 0: ---
stylesheet: variableAssignment* styleRule*;
styleRule: selector OPEN_BRACE ruleBody CLOSE_BRACE;
ruleBody: (declaration | ifClause | variableAssignment)+;

classselector: CLASS_IDENT;
idselector: ID_IDENT; // mogelijk ook color
tagselector: LOWER_IDENT;
selector: classselector | idselector | tagselector ;

propertyname: LOWER_IDENT+;
declaration: propertyname COLON (multiplyable | variableReference | expression) SEMICOLON ;

boolLiteral: TRUE | FALSE;
colorLiteral: COLOR;
percentageLiteral: PERCENTAGE;
pixelLiteral: PIXELSIZE;
scalarLiteral: SCALAR;

expressiontype: scalarLiteral | pixelLiteral  | percentageLiteral | colorLiteral | boolLiteral; // OR UNDIFINED
comparable: scalarLiteral | pixelLiteral | percentageLiteral;

// --- Level 1: ---
variableAssignment: variableReference ASSIGNMENT_OPERATOR expression SEMICOLON;
variableReference: (CAPITAL_IDENT | LOWER_IDENT)+;

// --- Level 2: ---
multiplyable: variableReference | expressiontype;

expression: expression multiplyoperation expression | expression (addoperation | substractoperation) expression | multiplyable;

addoperation: PLUS;
multiplyoperation: MUL;
substractoperation: MIN;

// --- Level 3: ---
ifClause: IF BOX_BRACKET_OPEN condition BOX_BRACKET_CLOSE OPEN_BRACE ruleBody CLOSE_BRACE elseClause?;
elseClause: ELSE OPEN_BRACE ruleBody CLOSE_BRACE;

// --- Uitbreiding booleaanse expressies: ---
compareOperator: SMALLERTHAN | GREATERTHAN;
equalsOperator: EQUALS;
notOperator: NOT;

condition: classic | equals | comparison | notExpression;
classic: variableReference | boolLiteral;
notExpression: notOperator classic;
equals: variableReference equalsOperator multiplyable ;
comparison: (variableReference | comparable ) compareOperator  (variableReference | comparable);


