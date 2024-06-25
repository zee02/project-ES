package model;

    public class Socio {
        private String nome;
        private String nifCc;
        private String telefone;
        private String morada;
        private String email;
        private String tipoNotificacao;
        private String funcionario;
        private String tipoSocio;

        // Construtor
        public Socio(String nome, String nifCc, String telefone, String morada, String email, String tipoNotificacao, String funcionario, String tipoSocio) {
            this.nome = nome;
            this.nifCc = nifCc;
            this.telefone = telefone;
            this.morada = morada;
            this.email = email;
            this.tipoNotificacao = tipoNotificacao;
            this.funcionario = funcionario;
            this.tipoSocio = tipoSocio;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNifCc() {
            return nifCc;
        }

        public void setNifCc(String nifCc) {
            this.nifCc = nifCc;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getMorada() {
            return morada;
        }

        public void setMorada(String morada) {
            this.morada = morada;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTipoNotificacao() {
            return tipoNotificacao;
        }

        public void setTipoNotificacao(String tipoNotificacao) {
            this.tipoNotificacao = tipoNotificacao;
        }

        public String getFuncionario() {
            return funcionario;
        }

        public void setFuncionario(String funcionario) {
            this.funcionario = funcionario;
        }

        public String getTipoSocio() {
            return tipoSocio;
        }

        public void setTipoSocio(String tipoSocio) {
            this.tipoSocio = tipoSocio;
        }

        @Override
        public String toString() {
            return "Socio{" +
                    "nome='" + nome + '\'' +
                    ", nifCc='" + nifCc + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", morada='" + morada + '\'' +
                    ", email='" + email + '\'' +
                    ", tipoNotificacao='" + tipoNotificacao + '\'' +
                    ", funcionario='" + funcionario + '\'' +
                    ", tipoSocio='" + tipoSocio + '\'' +
                    '}';
        }
    }


