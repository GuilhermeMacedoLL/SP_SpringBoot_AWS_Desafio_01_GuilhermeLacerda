package entidades.enums;

public enum SituacaoEmprestimo {
	ATIVO(1), 
	CONCLUIDO(2), 
	ATRASADO(3);

	private int codigo;

	SituacaoEmprestimo(int codigo) {
		this.codigo = codigo;
	}

	public static SituacaoEmprestimo fromCodigo(int codigo) {
		for (SituacaoEmprestimo situacao : SituacaoEmprestimo.values()) {
			if (situacao.codigo == codigo) {
				return situacao;
			}
		}
		throw new IllegalArgumentException("Código de situação inválido");
	}
}