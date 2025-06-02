CREATE TABLE users (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE student (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
    rji INTEGER,
    celular VARCHAR(20),
    genero VARCHAR(20) CHECK (genero IN ('Masculino', 'Feminino')),
    escolaridade VARCHAR(30) CHECK (
        escolaridade IN (
            'fundamental incompleto', 'fundamental completo',
            'médio incompleto', 'médio completo',
            'superior incompleto', 'superior completo',
            'pós-graduado', 'mestre', 'doutor'
        )
    ),
    historico_profissional VARCHAR(255),
    data_nascimento DATE,
    email VARCHAR(100),
    nome_mae VARCHAR(150),
    nome_pai VARCHAR(150),
    estado_civil VARCHAR(20) CHECK (estado_civil IN ('Solteiro', 'Casado', 'Divorciado', 'Viúvo', 'Outro')),
    local_nascimento VARCHAR(2) CHECK (
        local_nascimento IN (
            'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO',
            'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI',
            'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'
        )
    ),
    possui_deficiencia BOOLEAN,
    qual_deficiencia VARCHAR(255)
);

CREATE TABLE teacher (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL 
    celular VARCHAR(20),
    genero VARCHAR(20) CHECK (genero IN ('Masculino', 'Feminino')),
    data_nascimento DATE,
    email VARCHAR(100),
    nome_mae VARCHAR(150),
    nome_pai VARCHAR(150),
    estado_civil VARCHAR(20) CHECK (estado_civil IN ('Solteiro', 'Casado', 'Divorciado', 'Viúvo', 'Outro')),
    local_nascimento VARCHAR(2) CHECK (
        local_nascimento IN (
            'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO',
            'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI',
            'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'
        )
    ),
);

CREATE TABLE teacher_student (
    teacher_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    PRIMARY KEY (teacher_id, student_id),
    CONSTRAINT teacher_to_student_relation FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON DELETE CASCADE,
    CONSTRAINT student_to_teacher_relation FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);

CREATE TABLE post (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT post_user_relation FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);