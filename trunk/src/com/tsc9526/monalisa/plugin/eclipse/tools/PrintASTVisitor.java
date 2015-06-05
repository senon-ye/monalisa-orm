package com.tsc9526.monalisa.plugin.eclipse.tools;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.CreationReference;
import org.eclipse.jdt.core.dom.Dimension;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ExpressionMethodReference;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.IntersectionType;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LambdaExpression;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NameQualifiedType;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodReference;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeMethodReference;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.UnionType;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;

public class PrintASTVisitor extends ASTVisitor {
	 
	public PrintASTVisitor() {
		super();
	}
 
	public PrintASTVisitor(boolean visitDocTags) {
		super(visitDocTags);
	}

	protected boolean visitNode(ASTNode node) {
		System.out.println(">>>NODE: "+node.getClass()+"\r\n"+node);
		return true;
	}
	
	public void endVisit(AnnotationTypeDeclaration node) {
		endVisitNode(node);
	}

	public void endVisit(AnnotationTypeMemberDeclaration node) {
		endVisitNode(node);
	}

	public void endVisit(AnonymousClassDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(ArrayAccess node) {
		endVisitNode(node);
	}
	public void endVisit(ArrayCreation node) {
		endVisitNode(node);
	}
	public void endVisit(ArrayInitializer node) {
		endVisitNode(node);
	}
	public void endVisit(ArrayType node) {
		endVisitNode(node);
	}
	public void endVisit(AssertStatement node) {
		endVisitNode(node);
	}
	public void endVisit(Assignment node) {
		endVisitNode(node);
	}
	public void endVisit(Block node) {
		endVisitNode(node);
	}
	/* since 3.0 */
	public void endVisit(BlockComment node) {
		endVisitNode(node);
	}
	public void endVisit(BooleanLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(BreakStatement node) {
		endVisitNode(node);
	}
	public void endVisit(CastExpression node) {
		endVisitNode(node);
	}
	public void endVisit(CatchClause node) {
		endVisitNode(node);
	}
	public void endVisit(CharacterLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(ClassInstanceCreation node) {
		endVisitNode(node);
	}
	public void endVisit(CompilationUnit node) {
		endVisitNode(node);
	}
	public void endVisit(ConditionalExpression node) {
		endVisitNode(node);
	}
	public void endVisit(ConstructorInvocation node) {
		endVisitNode(node);
	}
	public void endVisit(ContinueStatement node) {
		endVisitNode(node);
	}
	public void endVisit(CreationReference node) {
		endVisitNode(node);
	}
	public void endVisit(Dimension node) {
		endVisitNode(node);
	}

	public void endVisit(DoStatement node) {
		endVisitNode(node);
	}
	public void endVisit(EmptyStatement node) {
		endVisitNode(node);
	}
	public void endVisit(EnhancedForStatement node) {
		endVisitNode(node);
	}
	public void endVisit(EnumConstantDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(EnumDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(ExpressionMethodReference node) {
		endVisitNode(node);
	}
	public void endVisit(ExpressionStatement node) {
		endVisitNode(node);
	}
	public void endVisit(FieldAccess node) {
		endVisitNode(node);
	}
	public void endVisit(FieldDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(ForStatement node) {
		endVisitNode(node);
	}
	public void endVisit(IfStatement node) {
		endVisitNode(node);
	}
	public void endVisit(ImportDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(InfixExpression node) {
		endVisitNode(node);
	}
	public void endVisit(Initializer node) {
		endVisitNode(node);
	}
	public void endVisit(InstanceofExpression node) {
		endVisitNode(node);
	}
	public void endVisit(IntersectionType node) {
		endVisitNode(node);
	}
	public void endVisit(Javadoc node) {
		endVisitNode(node);
	}
	public void endVisit(LabeledStatement node) {
		endVisitNode(node);
	}
	public void endVisit(LambdaExpression node) {
		endVisitNode(node);
	}
	public void endVisit(LineComment node) {
		endVisitNode(node);
	}
	public void endVisit(MarkerAnnotation node) {
		endVisitNode(node);
	}
	public void endVisit(MemberRef node) {
		endVisitNode(node);
	}
	public void endVisit(MemberValuePair node) {
		endVisitNode(node);
	}
	public void endVisit(MethodDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(MethodInvocation node) {
		endVisitNode(node);
	}
	public void endVisit(MethodRef node) {
		endVisitNode(node);
	}
	public void endVisit(MethodRefParameter node) {
		endVisitNode(node);
	}
	public void endVisit(Modifier node) {
		endVisitNode(node);
	}
	public void endVisit(NameQualifiedType node) {
		endVisitNode(node);
	}

	public void endVisit(NormalAnnotation node) {
		endVisitNode(node);
	}
	public void endVisit(NullLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(NumberLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(PackageDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(ParameterizedType node) {
		endVisitNode(node);
	}
	public void endVisit(ParenthesizedExpression node) {
		endVisitNode(node);
	}
	public void endVisit(PostfixExpression node) {
		endVisitNode(node);
	}
	public void endVisit(PrefixExpression node) {
		endVisitNode(node);
	}
	public void endVisit(PrimitiveType node) {
		endVisitNode(node);
	}
	public void endVisit(QualifiedName node) {
		endVisitNode(node);
	}
	public void endVisit(QualifiedType node) {
		endVisitNode(node);
	}
	public void endVisit(ReturnStatement node) {
		endVisitNode(node);
	}
	public void endVisit(SimpleName node) {
		endVisitNode(node);
	}
	public void endVisit(SimpleType node) {
		endVisitNode(node);
	}
	public void endVisit(SingleMemberAnnotation node) {
		endVisitNode(node);
	}
	public void endVisit(SingleVariableDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(StringLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(SuperConstructorInvocation node) {
		endVisitNode(node);
	}
	public void endVisit(SuperFieldAccess node) {
		endVisitNode(node);
	}
	public void endVisit(SuperMethodInvocation node) {
		endVisitNode(node);
	}
	public void endVisit(SuperMethodReference node) {
		endVisitNode(node);
	}
	public void endVisit(SwitchCase node) {
		endVisitNode(node);
	}
	public void endVisit(SwitchStatement node) {
		endVisitNode(node);
	}
	public void endVisit(SynchronizedStatement node) {
		endVisitNode(node);
	}
	public void endVisit(TagElement node) {
		endVisitNode(node);
	}
	public void endVisit(TextElement node) {
		endVisitNode(node);
	}
	public void endVisit(ThisExpression node) {
		endVisitNode(node);
	}
	public void endVisit(ThrowStatement node) {
		endVisitNode(node);
	}
	public void endVisit(TryStatement node) {
		endVisitNode(node);
	}

	public void endVisit(TypeDeclaration node) {
		endVisitNode(node);
	}
	public void endVisit(TypeDeclarationStatement node) {
		endVisitNode(node);
	}
	public void endVisit(TypeLiteral node) {
		endVisitNode(node);
	}
	public void endVisit(TypeMethodReference node) {
		endVisitNode(node);
	}
	public void endVisit(TypeParameter node) {
		endVisitNode(node);
	}
	public void endVisit(UnionType node) {
		endVisitNode(node);
	}
	public void endVisit(VariableDeclarationExpression node) {
		endVisitNode(node);
	}
	public void endVisit(VariableDeclarationFragment node) {
		endVisitNode(node);
	}
	public void endVisit(VariableDeclarationStatement node) {
		endVisitNode(node);
	}
	public void endVisit(WhileStatement node) {
		endVisitNode(node);
	}
	public void endVisit(WildcardType node) {
		endVisitNode(node);
	}
	protected void endVisitNode(ASTNode node) {
		// do nothing
	}
	public boolean visit(AnnotationTypeDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(AnnotationTypeMemberDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(AnonymousClassDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(ArrayAccess node) {
		return visitNode(node);
	}
	public boolean visit(ArrayCreation node) {
		return visitNode(node);
	}
	public boolean visit(ArrayInitializer node) {
		return visitNode(node);
	}
	public boolean visit(ArrayType node) {
		visitNode(node);
		return false;
	}
	public boolean visit(AssertStatement node) {
		return visitNode(node);
	}
	public boolean visit(Assignment node) {
		return visitNode(node);
	}
	public boolean visit(Block node) {
		return visitNode(node);
	}
	/* since 3.0 */
	public boolean visit(BlockComment node) {
		return visitNode(node);
	}
	public boolean visit(BooleanLiteral node) {
		return visitNode(node);
	}
	public boolean visit(BreakStatement node) {
		return visitNode(node);
	}
	public boolean visit(CastExpression node) {
		return visitNode(node);
	}
	public boolean visit(CatchClause node) {
		return visitNode(node);
	}
	public boolean visit(CharacterLiteral node) {
		return visitNode(node);
	}
	public boolean visit(ClassInstanceCreation node) {
		return visitNode(node);
	}
	public boolean visit(CompilationUnit node) {
		return visitNode(node);
	}
	public boolean visit(ConditionalExpression node) {
		return visitNode(node);
	}
	public boolean visit(ConstructorInvocation node) {
		return visitNode(node);
	}
	public boolean visit(ContinueStatement node) {
		return visitNode(node);
	}
	public boolean visit(CreationReference node) {
		return visitNode(node);
	}
	public boolean visit(Dimension node) {
		return visitNode(node);
	}

	public boolean visit(DoStatement node) {
		return visitNode(node);
	}
	public boolean visit(EmptyStatement node) {
		return visitNode(node);
	}
	public boolean visit(EnhancedForStatement node) {
		return visitNode(node);
	}
	public boolean visit(EnumConstantDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(EnumDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(ExpressionMethodReference node) {
		return visitNode(node);
	}
	public boolean visit(ExpressionStatement node) {
		return visitNode(node);
	}
	public boolean visit(FieldAccess node) {
		return visitNode(node);
	}
	public boolean visit(FieldDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(ForStatement node) {
		return visitNode(node);
	}
	public boolean visit(IfStatement node) {
		return visitNode(node);
	}
	public boolean visit(ImportDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(InfixExpression node) {
		return visitNode(node);
	}
	public boolean visit(Initializer node) {
		return visitNode(node);
	}
	public boolean visit(InstanceofExpression node) {
		return visitNode(node);
	}
	public boolean visit(IntersectionType node) {
		return visitNode(node);
	}
	public boolean visit(Javadoc node) {
		//	do not visit Javadoc tags by default. Use constructor with boolean to enable.
		if (super.visit(node)) {
			return visitNode(node);
		}
		return false;
	}
	public boolean visit(LabeledStatement node) {
		return visitNode(node);
	}
	public boolean visit(LambdaExpression node) {
		return visitNode(node);
	}
	public boolean visit(LineComment node) {
		return visitNode(node);
	}
	public boolean visit(MarkerAnnotation node) {
		return visitNode(node);
	}
	public boolean visit(MemberRef node) {
		return visitNode(node);
	}
	public boolean visit(MemberValuePair node) {
		return visitNode(node);
	}
	public boolean visit(MethodDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(MethodInvocation node) {
		return visitNode(node);
	}
	public boolean visit(MethodRef node) {
		return visitNode(node);
	}
	public boolean visit(Modifier node) {
		return visitNode(node);
	}
	public boolean visit(MethodRefParameter node) {
		return visitNode(node);
	}
	public boolean visit(NameQualifiedType node) {
		return visitNode(node);
	}

	public boolean visit(NormalAnnotation node) {
		return visitNode(node);
	}
	public boolean visit(NullLiteral node) {
		return visitNode(node);
	}
	public boolean visit(NumberLiteral node) {
		return visitNode(node);
	}
	public boolean visit(PackageDeclaration node) {
		return visitNode(node);
	}
	public boolean visit(ParameterizedType node) {
		return visitNode(node);
	}
	public boolean visit(ParenthesizedExpression node) {
		return visitNode(node);
	}
	public boolean visit(PostfixExpression node) {
		return visitNode(node);
	}
	public boolean visit(PrefixExpression node) {
		return visitNode(node);
	}

	public boolean visit(PrimitiveType node) {
		return visitNode(node);
	}
	public boolean visit(QualifiedName node) {
		return visitNode(node);
	}
	public boolean visit(QualifiedType node) {
		return visitNode(node);
	}
	public boolean visit(ReturnStatement node) {
		return visitNode(node);
	}
	public boolean visit(SimpleName node) {
		return visitNode(node);
	}
	public boolean visit(SimpleType node) {
		return visitNode(node);
	}
	public boolean visit(SingleMemberAnnotation node) {
		return visitNode(node);
	}
	public boolean visit(SingleVariableDeclaration node) {
		return visitNode(node);
	}

	public boolean visit(StringLiteral node) {
		return visitNode(node);
	}

	public boolean visit(SuperConstructorInvocation node) {
		return visitNode(node);
	}

	public boolean visit(SuperFieldAccess node) {
		return visitNode(node);
	}

	public boolean visit(SuperMethodInvocation node) {
		return visitNode(node);
	}

	public boolean visit(SuperMethodReference node) {
		return visitNode(node);
	}

	public boolean visit(SwitchCase node) {
		return visitNode(node);
	}

	public boolean visit(SwitchStatement node) {
		return visitNode(node);
	}

	public boolean visit(SynchronizedStatement node) {
		return visitNode(node);
	}

	public boolean visit(TagElement node) {
		return visitNode(node);
	}

	public boolean visit(TextElement node) {
		return visitNode(node);
	}

	public boolean visit(ThisExpression node) {
		return visitNode(node);
	}

	public boolean visit(ThrowStatement node) {
		return visitNode(node);
	}

	public boolean visit(TryStatement node) {
		return visitNode(node);
	}

	public boolean visit(TypeDeclaration node) {
		return visitNode(node);
	}

	public boolean visit(TypeDeclarationStatement node) {
		return visitNode(node);
	}

	public boolean visit(TypeLiteral node) {
		return visitNode(node);
	}

	public boolean visit(TypeMethodReference node) {
		return visitNode(node);
	}

	public boolean visit(TypeParameter node) {
		return visitNode(node);
	}

	public boolean visit(UnionType node) {
		return visitNode(node);
	}
	
	public boolean visit(VariableDeclarationExpression node) {
		return visitNode(node);
	}

	public boolean visit(VariableDeclarationFragment node) {
		return visitNode(node);
	}

	public boolean visit(VariableDeclarationStatement node) {
		return visitNode(node);
	}

	public boolean visit(WhileStatement node) {
		return visitNode(node);
	}

	public boolean visit(WildcardType node) {
		return visitNode(node);
	}	

}
